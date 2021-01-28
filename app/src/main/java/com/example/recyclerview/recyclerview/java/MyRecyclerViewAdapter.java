package com.example.recyclerview.recyclerview.java;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.network.ImageEntity;
import com.example.recyclerview.R;

import java.util.List;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/25
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private final List<ImageEntity.DataDTO.ListDTO> mImageUrlList;
    private RecyclerView recyclerView;

    private final Context mContext;

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOT = 2;

    //当前加载状态 默认为加载完成
    private int loadState = LOADING_COMPLETE;

    public static final int LOADING = 1;

    public static final int LOADING_COMPLETE = 2;

    public static final int LOADING_END = 3;

    public MyRecyclerViewAdapter(Context context, List<ImageEntity.DataDTO.ListDTO> imageslist) {
        this.mContext = context;
        this.mImageUrlList = imageslist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOT) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_footer, parent, false);
            return new FooterViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_grid, parent, false);
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
            Glide.with(mContext)
                    .load(mImageUrlList.get(position).getImageUrl())
                    .fitCenter()
                    .into(viewHolder.mIv);
        } else {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            switch (loadState) {
                case LOADING: // 正在加载
                    footerViewHolder.loadingLayout.setVisibility(View.VISIBLE);
                    footerViewHolder.loadedLayout.setVisibility(View.GONE);
                    break;

                case LOADING_COMPLETE: // 加载完成
                    footerViewHolder.loadingLayout.setVisibility(View.GONE);
                    footerViewHolder.loadedLayout.setVisibility(View.GONE);
                    break;

                case LOADING_END: // 加载到底
                    footerViewHolder.loadingLayout.setVisibility(View.GONE);
                    footerViewHolder.loadedLayout.setVisibility(View.VISIBLE);
                    break;

                default:
                    break;
            }
        }
    }

    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mImageUrlList.size() > 0 ? mImageUrlList.size() + 1 : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOT;
        } else {
            return TYPE_ITEM;
        }
    }



    @Override
    public void onClick(View v) {
        int position = recyclerView.getChildAdapterPosition(v);

        if (mOnItemClickListener !=null ){
            mOnItemClickListener.onItemClick(recyclerView,v,position,mImageUrlList.get(position).getImageUrl());
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.ivItemGrid);

        }
    }

    private static class FooterViewHolder extends RecyclerView.ViewHolder {
        private final RelativeLayout loadingLayout;
        private final LinearLayout loadedLayout;

        public FooterViewHolder(View view) {
            super(view);
            loadingLayout = view.findViewById(R.id.rl_loading);
            loadedLayout = view.findViewById(R.id.ll_loading_end);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(RecyclerView parent,View view,int position,String data);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (getItemViewType(position) == TYPE_FOOT){
                        return ((GridLayoutManager) layoutManager).getSpanCount();
                    }else {
                        return 1;
                    }
                }
            });
        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }
}
