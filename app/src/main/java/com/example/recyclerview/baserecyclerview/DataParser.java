package com.example.recyclerview.baserecyclerview;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.recyclerview.network.ImageEntity;
import com.example.recyclerview.network.ImageService;
import com.example.recyclerview.recyclerview.java.RetrofitHelper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Xiaozh
 * @data 2021/1/18
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class DataParser {
    private final RetrofitHelper retrofitHelper;
    private final List<ImageEntity.DataDTO.ListDTO> mListImageUrl;
    private final BaseRecyclerAdapter mAdapter;
    private boolean isErr;
    private final Context context;

    public DataParser(RetrofitHelper retrofitHelper,
                   BaseRecyclerAdapter mAdapter,
                   List<ImageEntity.DataDTO.ListDTO> mListImageUrl,
                   boolean isErr, Context context) {
        this.retrofitHelper = retrofitHelper;
        this.mAdapter = mAdapter;
        this.mListImageUrl = mListImageUrl;
        this.isErr = isErr;
        this.context = context;
    }

    public void getData(int page) {

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
                            if (mAdapter != null) {
                                mAdapter.notifyDataSetChanged();
                            }
                            mAdapter.loadMoreComplete();
                        } else {
                            isErr = true;
                            Toast.makeText(context, "获取数据失败", Toast.LENGTH_SHORT).show();
                            mAdapter.loadMoreFail();
                        }
                    }


                } else {
                    mListImageUrl.clear();
                    mListImageUrl.addAll(data);
                    if (mAdapter != null) {
                        mAdapter.notifyDataSetChanged();
                    }

                }


            }

            @Override
            public void onFailure(@NotNull Call<ImageEntity> call, @NotNull Throwable t) {
                Log.d("TAG", t.getMessage());
            }
        });

    }
}




