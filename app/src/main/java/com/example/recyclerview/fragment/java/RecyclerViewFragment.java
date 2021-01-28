package com.example.recyclerview.fragment.java;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.recyclerview.network.ImageEntity;
import com.example.recyclerview.network.ImageService;
import com.example.recyclerview.R;
import com.example.recyclerview.recyclerview.java.EndlessRecyclerOnScrollListener;
import com.example.recyclerview.recyclerview.java.MyRecyclerViewAdapter;
import com.example.recyclerview.recyclerview.java.RetrofitHelper;
import com.example.recyclerview.recyclerview.java.SpaceItemDecoration;
import com.example.recyclerview.recyclerview.kotlin.ItemActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/29
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class RecyclerViewFragment extends Fragment {


    public static RecyclerViewFragment newInstance() {
        Bundle args = new Bundle();
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private final List<ImageEntity.DataDTO.ListDTO> mListImageUrl = new ArrayList<>();

    private MyRecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefresh;

    private int page = 1;

    private final RetrofitHelper retrofitHelper = RetrofitHelper.getInstance();

    protected Activity mActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.activity_recyclerview, container, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        mRefresh = view.findViewById(R.id.swipeRefresh);

        mRefresh.setOnRefreshListener(() -> {
            page = 1;
            getData(page);
        });
        initRecycler();
        getData(page);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void initRecycler() {
        int spanCount = 2;
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), spanCount);
        mAdapter = new MyRecyclerViewAdapter(getContext(), mListImageUrl);
        //设置item间距 10dp
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter.setOnItemClickListener((parent, view, position, data) -> {
            Intent intent = new Intent(view.getContext(), ItemActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("data", data);
            intent.putExtras(bundle);
            startActivity(intent);

        });
        mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            protected void onLoadMore() {
                mAdapter.setLoadState(MyRecyclerViewAdapter.LOADING);

                mRecyclerView.postDelayed(() -> {
                    getData(++page);
                    mAdapter.setLoadState(MyRecyclerViewAdapter.LOADING_COMPLETE);
                }, 1000);

            }
        });
    }

    private void getData(int page) {
        Call<ImageEntity> call = retrofitHelper.getService(ImageService.class)
                .getCount(page, "mmvpmnnvrkscwzvq", "VjVXZ2dXNlp3NjlHUnhsNTVTaWsvZz09");


        call.enqueue(new Callback<ImageEntity>() {
            @Override
            public void onResponse(@NonNull Call<ImageEntity> call,
                                   @NonNull Response<ImageEntity> response) {
                ImageEntity body = response.body();
                if (body == null) {
                    return;
                }
                if (page > 1) {
                    //加载更多
                    List<ImageEntity.DataDTO.ListDTO> data = body.getData().getList();
                    if (data == null || data.size() <= 0) {
                        mAdapter.setLoadState(MyRecyclerViewAdapter.LOADING_END);
                        return;
                    }
                    mListImageUrl.addAll(data);
                    mAdapter.notifyDataSetChanged();
                } else {
                    //刷新
                    mListImageUrl.clear();
                    mListImageUrl.addAll(body.getData().getList());
                    mAdapter.notifyDataSetChanged();
                    //设置刷新状态
                    if (mRefresh.isRefreshing()) {
                        mRefresh.setRefreshing(false);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ImageEntity> call, @NonNull Throwable t) {
                Log.d("TAG", t.getMessage());

            }
        });

    }


}
