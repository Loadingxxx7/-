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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.recyclerview.R;
import com.example.recyclerview.network.WeatherEntity;
import com.example.recyclerview.network.WeatherService;
import com.example.recyclerview.network.kotlin.Data1;
import com.example.recyclerview.network.kotlin.DayWeatherEntityKotlin;
import com.example.recyclerview.network.kotlin.DayWeatherKotlin;
import com.example.recyclerview.recyclerview.java.RetrofitHelper;
import com.example.recyclerview.recyclerview.java.RetrofitManager;
import com.example.recyclerview.recyclerview.java.SpaceItemDecoration;
import com.example.recyclerview.recyclerview.java.WeatherAdapter;
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
 * @data 2020/12/29
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class WeatherFragment extends Fragment {


    public static WeatherFragment newInstance() {
        Bundle args = new Bundle();
        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private final List<WeatherEntity.DataDTO> mListImageUrl = new ArrayList<>();
    private final List<Data1> mWeather = new ArrayList<>();

    private WeatherAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefresh;

    private final RetrofitManager retrofitManager = new RetrofitManager("https://api.66mz8.com/api/");
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
            getData();
            getWeather();
        });
        initRecycler();
        getData();
        getWeather();
        return view;
    }



    @Override
    public void onResume() {
        super.onResume();

    }

    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new WeatherAdapter(getContext(), mListImageUrl,mWeather);
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


    }

    private void getData() {
        Call<WeatherEntity> call = retrofitManager.getService(WeatherService.class)
                .getCity("广州");

        call.enqueue(new Callback<WeatherEntity>() {
            @Override
            public void onResponse(@NonNull Call<WeatherEntity> call,
                                   @NonNull Response<WeatherEntity> response) {
                WeatherEntity body = response.body();
                if (body == null) {
                    return;
                }
                List<WeatherEntity.DataDTO> data = body.getData();
                if (data != null) {
                    //刷新
                    mListImageUrl.clear();
                    mListImageUrl.addAll(data);
                    mAdapter.notifyDataSetChanged();
                    //设置刷新状态
                    if (mRefresh.isRefreshing()) {
                        mRefresh.setRefreshing(false);
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<WeatherEntity> call, @NonNull Throwable t) {
                Log.d("TAG", t.getMessage());

            }
        });

    }
    private void getWeather() {
        Call<DayWeatherEntityKotlin> call = retrofitHelper.getService(DayWeatherKotlin.class)
                .getWeather("广州","mmvpmnnvrkscwzvq","VjVXZ2dXNlp3NjlHUnhsNTVTaWsvZz09");
        call.enqueue(new Callback<DayWeatherEntityKotlin>() {
            @Override
            public void onResponse(
                    @NotNull Call<DayWeatherEntityKotlin> call,
                    @NotNull Response<DayWeatherEntityKotlin> response
            ) {
                DayWeatherEntityKotlin body = response.body();
                if (body == null){
                    return;
                }
                Data1 data1s = body.getData();
                mWeather.clear();
                mWeather.add(data1s);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NotNull Call<DayWeatherEntityKotlin> call, @NotNull Throwable t) {
                Log.d("TAG", t.getMessage());

            }
        });
    }

}
