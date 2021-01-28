package com.example.recyclerview.baserecyclerview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.example.recyclerview.R;
import com.example.recyclerview.network.ImageEntity;
import com.example.recyclerview.network.ImageService;
import com.example.recyclerview.recyclerview.java.RetrofitHelper;
import com.example.recyclerview.recyclerview.java.SpaceItemDecoration;
import com.example.recyclerview.recyclerview.kotlin.ItemActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/16
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class BaseRecyclerViewFragment extends Fragment {

    public static BaseRecyclerViewFragment newInstance() {

        Bundle args = new Bundle();
        BaseRecyclerViewFragment fragment = new BaseRecyclerViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private final List<ImageEntity.DataDTO.ListDTO> mListImageUrl = new ArrayList<>();
    private final RetrofitHelper retrofitHelper = RetrofitHelper.getInstance();


    private RecyclerView mRecyclerView;
    private BaseRecyclerAdapter mAdapter;

    private View view, headView;

    private int page = 1;

    private boolean isErr = true;//判断数据是否加载错误

    private DataParser dataParser;

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_baserecyclerview, container, false);
        headView = LayoutInflater.from(getContext()).inflate(R.layout.item_head, null, false);
        mRecyclerView = view.findViewById(R.id.baseRecycler);

        initRecycler();
        //        getData(page);
        dataParser = new DataParser(retrofitHelper, mAdapter, mListImageUrl, isErr, getContext());
        dataParser.getData(page);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        mAdapter = new BaseRecyclerAdapter(mListImageUrl);
        ItemDragAndSwipeCallback callback = new ItemDragAndSwipeCallback(mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
        //开启拖拽
        mAdapter.enableDragItem(itemTouchHelper, R.id.btn_item, true);
        mAdapter.setOnItemDragListener(new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder1, int i1) {

            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int i) {
                Toast.makeText(getContext(), "拖拽完成", Toast.LENGTH_SHORT).show();
            }
        });

        //开启删除
        mAdapter.enableSwipeItem();

        mAdapter.setNewData(mListImageUrl);
        mAdapter.setEmptyView(R.layout.fragment_null, (ViewGroup) view);

        mAdapter.addHeaderView(headView);
        mAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.iv_item:
                    Intent intent = new Intent(view.getContext(), ItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("data", mListImageUrl.get(position).getImageUrl());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case R.id.btn_item:
                    Intent intent1 = new Intent(view.getContext(), DetailsItemActivity.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("url", mListImageUrl.get(position).getImageUrl());
                    bundle1.putString("size", mListImageUrl.get(position).getImageSize());
                    bundle1.putInt("length", mListImageUrl.get(position).getImageFileLength());
                    intent1.putExtras(bundle1);
                    startActivity(intent1);
                    break;
            }
        });
        mAdapter.setOnItemChildLongClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.tv_item:
                    Toast.makeText(getContext(), "图片尺寸为" + mListImageUrl.get(position).getImageSize(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tv_item_2:
                    Toast.makeText(getContext(), "文件字节数为" + mListImageUrl.get(position).getImageFileLength(), Toast.LENGTH_SHORT).show();
            }

            return false;
        });
        //设置动画
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //设置重复执行动画
        //        mAdapter.isFirstOnly(false);
        //上拉加载
        mAdapter.setOnLoadMoreListener(() -> mRecyclerView.postDelayed(() -> {
            //                        getData(++page);
            dataParser.getData(++page);
        }, 1000), mRecyclerView);

        mRecyclerView.setAdapter(mAdapter);
    }

    private void getData(int page) {
        Call<ImageEntity> call = retrofitHelper.getService(ImageService.class)
                .getCount(page, "mmvpmnnvrkscwzvq", "VjVXZ2dXNlp3NjlHUnhsNTVTaWsvZz09");
        call.enqueue(new Callback<ImageEntity>() {
            @Override
            public void onResponse(@NotNull Call<ImageEntity> call, @NotNull Response<ImageEntity> response) {
                ImageEntity body = response.body();
                if (body == null) {
                    return;
                }
                List<ImageEntity.DataDTO.ListDTO> data = body.getData().getList();
                if (page > 1) {

                    if (data == null || data.size() <= 0) {
                        mAdapter.loadMoreEnd();
                    } else {
                        if (isErr) {
                            mListImageUrl.addAll(data);
                            mAdapter.notifyDataSetChanged();
                            mAdapter.loadMoreComplete();
                        } else {
                            isErr = true;
                            Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
                            mAdapter.loadMoreFail();
                        }
                    }


                } else {
                    mListImageUrl.clear();
                    mListImageUrl.addAll(data);
                    mAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(@NotNull Call<ImageEntity> call, @NotNull Throwable t) {
                Log.d("TAG", t.getMessage());
            }
        });

    }
}
