package com.example.recyclerview.oep

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.recyclerview.R

/**
 * @author Xiaozh
 * @version
 * @data 2021/1/26
 * @email xiaozihuan994@qq.com
 * @description .
 */
class DiscussionImageRecyclerAdapter(
        layoutResId: Int) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId) {
    override fun convert(helper: BaseViewHolder, item: String?) {
        Glide.with(mContext)
                .load(item)
                .into(helper.getView(R.id.ivContent))
        helper.addOnClickListener(R.id.ivContent)

    }
}