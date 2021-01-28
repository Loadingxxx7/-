package com.example.recyclerview.baserecyclerview;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.recyclerview.network.ImageEntity;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/18
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class MyMultipleItem implements MultiItemEntity {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_ITEM = 3;

    private final int itemType;
    private final ImageEntity.DataDTO.ListDTO data;

    public MyMultipleItem(int itemType,ImageEntity.DataDTO.ListDTO data){
        this.itemType = itemType;
        this.data = data;
    }
    @Override
    public int getItemType() {
        return itemType;
    }

    public ImageEntity.DataDTO.ListDTO getData(){
        return data;
    }
}
