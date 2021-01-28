package com.example.recyclerview.recyclerview.java;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.recyclerview.R;
import com.example.recyclerview.network.WeatherEntity;
import com.example.recyclerview.network.kotlin.Data1;

import java.util.List;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/25
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private final List<WeatherEntity.DataDTO> mImageUrlList;
    private final List<Data1> mWeatherList;
    private RecyclerView recyclerView;

    private final Context mContext;

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEAD = 3;

    public WeatherAdapter(Context context, List<WeatherEntity.DataDTO> imageslist,List<Data1> weatherList) {
        this.mContext = context;
        this.mImageUrlList = imageslist;
        this.mWeatherList = weatherList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_header, parent, false);
            return new HeaderViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_rv, parent, false);
            view.setOnClickListener(this);
            return new ViewHolder(view);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            if (mImageUrlList == null || mImageUrlList.isEmpty())
                return;
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.mTv.setText(mImageUrlList.get(position-1).getDays() +" "+
                    mImageUrlList.get(position-1).getWeek() +"\n"+
                    mImageUrlList.get(position-1).getTemperature() +"  "+
                    mImageUrlList.get(position-1).getWeather()+"  "+
                    mImageUrlList.get(position-1).getWind());
            Glide.with(mContext)
                    .load(mImageUrlList.get(position-1).getWeatherIcon())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(viewHolder.mIv);
        } else if(holder instanceof HeaderViewHolder) {
            if (mWeatherList == null || mWeatherList.isEmpty()){
                return;
            }
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.tvAddress.setText(mWeatherList.get(0).getAddress());
            headerViewHolder.tvReportTime.setText(mWeatherList.get(0).getReportTime());
            headerViewHolder.tvTemp.setText(mWeatherList.get(0).getTemp());
            headerViewHolder.tvWeather.setText(mWeatherList.get(0).getWeather());
            headerViewHolder.tvWind.setText(mWeatherList.get(0).getWindDirection()+"风"
                    +mWeatherList.get(0).getWindPower());
            headerViewHolder.tvHumidity.setText("湿度"+mWeatherList.get(0).getHumidity());

        }
    }


    @Override
    public int getItemCount() {
        return mImageUrlList.size() > 0 ? mImageUrlList.size() + 1 : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onClick(View v) {
        int position = recyclerView.getChildAdapterPosition(v);

        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(recyclerView, v, position, mImageUrlList.get(position).getWeatherIcon());
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv;
        private final TextView mTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv_item);
            mTv = itemView.findViewById(R.id.tv_item);

        }
    }


    private static class HeaderViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvAddress,tvReportTime,tvTemp,tvWeather,tvWind,tvHumidity;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvReportTime = itemView.findViewById(R.id.tvReportTime);
            tvTemp = itemView.findViewById(R.id.tvTemp);
            tvWeather = itemView.findViewById(R.id.tvWeather);
            tvWind = itemView.findViewById(R.id.tvWind);
            tvHumidity = itemView.findViewById(R.id.tvHumidity);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerView parent, View view, int position, String data);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }
}
