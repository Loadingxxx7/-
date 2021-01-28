package com.example.recyclerview.baserecyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.network.ImageEntity;
import com.example.recyclerview.network.ImageService;
import com.example.recyclerview.network.TideEntity;
import com.example.recyclerview.network.TideService;
import com.example.recyclerview.recyclerview.java.RetrofitHelper;
import com.example.recyclerview.recyclerview.java.RetrofitManager;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MultipleItemFragment extends Fragment {
    public static MultipleItemFragment newInstance() {

        Bundle args = new Bundle();

        MultipleItemFragment fragment = new MultipleItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView mRecycler;
    private MultipleItemAdapter mAdapter;

    private final List<TideEntity> mData = new ArrayList<>();
//    private final RetrofitManager retrofitHelper = new RetrofitManager("https://api.seniverse.com/");

    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_multiple_item, container, false);
        mRecycler = view.findViewById(R.id.multipleRecycler);

        initRecycler();
//        getData(page);
        return view;
    }

    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new MultipleItemAdapter(mData);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }

//    private void getData(int page) {
//        Call<TideEntity> call = retrofitHelper.getService(TideService.class)
//                .getTideData("SlaQD2S7Krx5hnI-t","shanwei");
//        call.enqueue(new Callback<TideEntity>() {
//            @Override
//            public void onResponse(@NotNull Call<TideEntity> call, @NotNull Response<TideEntity> response) {
//
//            }
//
//            @Override
//            public void onFailure(@NotNull Call<TideEntity> call, @NotNull Throwable t) {
//                Log.d("TAG", t.getMessage());
//            }
//        });
//    }
}