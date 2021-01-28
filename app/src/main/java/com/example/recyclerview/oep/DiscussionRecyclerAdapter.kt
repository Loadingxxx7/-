package com.example.recyclerview.oep

import android.content.Intent
import android.text.TextUtils
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
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
class DiscussionRecyclerAdapter(
        layoutResId: Int,
        data: MutableList<DiscussionEntity>?
) : BaseQuickAdapter<DiscussionEntity, BaseViewHolder>(layoutResId, data) {

    private val imageAdapter = DiscussionImageRecyclerAdapter(R.layout.item_discussion_image)

    override fun convert(helper: BaseViewHolder, item: DiscussionEntity) {
        val roundedCorners = RoundedCorners(200)
        val options = RequestOptions.bitmapTransform(roundedCorners)
        helper.setText(R.id.tvUserName, item.userName)
                .setText(R.id.tvCourseName, item.courseName)
                .setText(R.id.tvContent, item.content)
                .setText(R.id.tvTime, item.time)
                .setText(R.id.tvLikeNum, item.likeNum.toString())
                .setText(R.id.tvCommentNum, item.commentNum.toString())
                .addOnClickListener(R.id.ivLike)
                .addOnClickListener(R.id.imageRecycler)
        helper.getView<TextView>(R.id.tvCourseName).isSingleLine = true
        helper.getView<TextView>(R.id.tvCourseName).ellipsize = TextUtils.TruncateAt.END

        Glide.with(mContext)
                .load(item.userIconURL)
                .apply(options)
                .into(helper.getView(R.id.ivUserIcon))

        val imageRecycler = helper.getView<RecyclerView>(R.id.imageRecycler)
        if (imageRecycler.adapter == null) {
            val layoutManager = GridLayoutManager(mContext, 3)
            imageRecycler.layoutManager = layoutManager
            imageRecycler.adapter = imageAdapter
        }
        imageAdapter.setNewData(item.urls)
        imageAdapter.setOnItemChildClickListener { _, view, position ->
            if (view.id == R.id.ivContent) {
                val intent = Intent(mContext, DiscussionImageDetailActivity::class.java).apply {
                    putExtra("position", position)
                    putStringArrayListExtra("imageUrlList", item.urls)
                }
                mContext.startActivity(intent)
            }
        }
    }
}