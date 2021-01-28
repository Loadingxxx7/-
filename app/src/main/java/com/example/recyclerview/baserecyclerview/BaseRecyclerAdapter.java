package com.example.recyclerview.baserecyclerview;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.recyclerview.R;
import com.example.recyclerview.network.ImageEntity;

import java.util.List;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/16
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class BaseRecyclerAdapter extends BaseItemDraggableAdapter<ImageEntity.DataDTO.ListDTO, BaseViewHolder> {
    public BaseRecyclerAdapter(@Nullable List<ImageEntity.DataDTO.ListDTO> data) {
        super(R.layout.item_rv, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ImageEntity.DataDTO.ListDTO item) {
        helper.setText(R.id.tv_item,"imageSize:"+item.getImageSize())
                .setText(R.id.tv_item_2,"FileLength:"+item.getImageFileLength())
                .addOnClickListener(R.id.btn_item)
                .addOnClickListener(R.id.iv_item)
                .addOnLongClickListener(R.id.tv_item)
                .addOnLongClickListener(R.id.tv_item_2);
        Glide.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.iv_item));

    }
}
