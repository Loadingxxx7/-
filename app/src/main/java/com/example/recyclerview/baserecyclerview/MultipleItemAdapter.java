package com.example.recyclerview.baserecyclerview;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.recyclerview.R;
import com.example.recyclerview.network.TideEntity;

import java.util.List;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/18
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class MultipleItemAdapter extends BaseMultiItemQuickAdapter<TideEntity, BaseViewHolder> {

    public final static int TYPE_ONE = 0;
    public final static int TYPE_TWO = 1;
    public final static int TYPE_ITEM = 2;


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemAdapter(List<TideEntity> data) {
        super(data);
        addItemType(TYPE_ITEM, R.layout.item_head);
        addItemType(TYPE_ONE, R.layout.item_head);
        addItemType(TYPE_TWO, R.layout.item_head);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, TideEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_ITEM:
                helper.setText(R.id.tv_head, item.getResults().get(helper.getLayoutPosition()).getLocation().getName());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        if (true) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case TYPE_TWO:

        }
    }
}
