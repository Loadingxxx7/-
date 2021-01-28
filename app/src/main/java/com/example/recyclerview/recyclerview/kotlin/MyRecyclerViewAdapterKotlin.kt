package com.example.recyclerview.recyclerview.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import com.example.recyclerview.network.kotlin.NewData

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/31
 * @email xiaozihuan994@qq.com
 * @description .
 */
open class MyRecyclerViewAdapterKotlin(
        private val context: Context?,
        private val imageList: List<NewData>,

        ) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener {

    private var recyclerView: RecyclerView? = null

    private var mOnItemClickListener: OnItemClickListener? = null


    private val TYPE_ITEM = 1
    private val TYPE_FOOT = 2


    private val LOADING = 1
    private val LOADING_COMPLETE = 2
    private val LOADING_END = 3

    private var loadState: Int = LOADING_COMPLETE

    lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_FOOT) {
            view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_footer, parent, false)
            FooterViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_rv, parent, false)
            view.setOnClickListener(this)
            ViewHolder(view)
        }
    }

    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        var mTextView: TextView = view!!.findViewById(R.id.tv_item)
        var mImageView: ImageView = view!!.findViewById(R.id.iv_item)
    }

    class FooterViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        var loadingLayout: RelativeLayout = view!!.findViewById(R.id.rl_loading)
        var loadedLayout: LinearLayout = view!!.findViewById(R.id.ll_loading_end)

    }


    override fun getItemCount(): Int = if (imageList.isNotEmpty()) imageList.size + 1 else 1

    override fun getItemViewType(position: Int): Int = if (position + 1 == itemCount) TYPE_FOOT else TYPE_ITEM


    fun setLoadState(loadState: Int) {
        this.loadState = loadState
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            if (imageList.isEmpty()) return
            val viewHolder: ViewHolder = holder
            imageList[position].run{
                viewHolder.mTextView.text = title
                Glide.with(view.context)
                        .load(pic)
                        .into(viewHolder.mImageView)
            }

        } else {
            val footerViewHolder: FooterViewHolder = holder as FooterViewHolder
            when (loadState) {
                LOADING -> {
                    footerViewHolder.loadingLayout.visibility = View.VISIBLE
                    footerViewHolder.loadedLayout.visibility = View.GONE
                }
                LOADING_COMPLETE -> {
                    footerViewHolder.loadingLayout.visibility = View.GONE
                    footerViewHolder.loadedLayout.visibility = View.GONE
                }
                LOADING_END -> {
                    footerViewHolder.loadingLayout.visibility = View.GONE
                    footerViewHolder.loadedLayout.visibility = View.VISIBLE
                }
            }
        }
    }


    override fun onClick(v: View?) {
        val position: Int = recyclerView!!.getChildAdapterPosition(v!!)

        if (mOnItemClickListener != null) {
            mOnItemClickListener!!.onItemClick(
                    recyclerView!!,
                    v,
                    position,
                    imageList[position].pic,
                    imageList[position].content,
                    imageList[position].title
            )
        }
    }

    interface OnItemClickListener {
        fun onItemClick(parent: RecyclerView,
                        view: View?,
                        position: Int,
                        url: String,
                        desc: String,
                        title: String
        )
    }

    open fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null
    }
}