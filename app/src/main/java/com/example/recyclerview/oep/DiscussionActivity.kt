package com.example.recyclerview.oep

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.R
import com.example.recyclerview.recyclerview.kotlin.SpaceItemDecorationKotlin
import kotlinx.android.synthetic.main.activity_discussion.*
import kotlinx.android.synthetic.main.item_discussion.*

class DiscussionActivity : AppCompatActivity() {

    private var data = ArrayList<DiscussionEntity>()
    private var value = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discussion)

        val layoutManager = LinearLayoutManager(this)
        discussionRecycler.layoutManager = layoutManager

        data = DiscussionData.getData(value)

        val mAdapter = DiscussionRecyclerAdapter(R.layout.item_discussion, data)
        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            if (view.id == R.id.ivLike) {
                ++data[position].likeNum
                adapter.setNewData(data)
            }
        }
        discussionSwipe.setOnRefreshListener {
            discussionRecycler.postDelayed({
                mAdapter.setNewData(data)
                if (discussionSwipe.isRefreshing) {
                    discussionSwipe.isRefreshing = false
                }
            }, 1000)
        }

        mAdapter.setOnLoadMoreListener({
            discussionRecycler.postDelayed({
                mAdapter.addData(DiscussionData.getData(++value))
                mAdapter.loadMoreComplete()
            }, 1000)
        }, discussionRecycler)

        discussionRecycler.adapter = mAdapter
    }

}