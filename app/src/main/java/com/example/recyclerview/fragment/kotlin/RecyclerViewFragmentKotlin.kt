package com.example.recyclerview.fragment.kotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.recyclerview.R
import com.example.recyclerview.network.kotlin.NewData
import com.example.recyclerview.network.kotlin.NewsEntityKotlin
import com.example.recyclerview.network.kotlin.NewsServiceKotlin
import com.example.recyclerview.recyclerview.kotlin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/31
 * @email xiaozihuan994@qq.com
 * @description .
 */
open class RecyclerViewFragmentKotlin : Fragment() {
    fun newInstance(): RecyclerViewFragmentKotlin {
        val args = Bundle()

        val fragment = RecyclerViewFragmentKotlin()
        fragment.arguments = args
        return fragment
    }

    private val mListImageUrl: ArrayList<NewData> = ArrayList()

    private var mAdapter: MyRecyclerViewAdapterKotlin = MyRecyclerViewAdapterKotlin(context, this.mListImageUrl)

    private var count = 10

    private val retrofitCreator: RetrofitCreator = RetrofitCreator.instance

    private lateinit var mActivity: Activity

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView

    private val LOADING = 1
    private val LOADING_COMPLETE = 2
    private val LOADING_END = 3


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mActivity = context as Activity

    }


    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.activity_recyclerview, container, false)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)
        recyclerView = view.findViewById(R.id.recycler)
        swipeRefreshLayout.setColorSchemeColors(R.color.orange)
        swipeRefreshLayout.setOnRefreshListener {
            getData(count)
        }
        initRecycler()
        getData(count)
        return view
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(SpaceItemDecorationKotlin(10))
        recyclerView.layoutManager = layoutManager

        mAdapter.setOnItemClickListener(object : MyRecyclerViewAdapterKotlin.OnItemClickListener {
            override fun onItemClick(parent: RecyclerView,
                                     view: View?,
                                     position: Int,
                                     url: String,
                                     desc: String,
                                     title: String
            ) {
                val intent = Intent(activity, NewsActivity::class.java).apply {
                    putExtra("url", url)
                    putExtra("desc", desc)
                    putExtra("title", title)
                }
                startActivity(intent)
            }
        })


        recyclerView.adapter = mAdapter

        recyclerView.addOnScrollListener(object : EndlessRecyclerOnScrollListenerKotlin() {
            override fun onLoadMore() {
                mAdapter.setLoadState(LOADING)

                recyclerView.postDelayed({
                    getData(++count)
                    mAdapter.setLoadState(LOADING_COMPLETE)
                }, 1000)
            }

        })
    }

    private fun getData(count: Int) {


        val call: Call<NewsEntityKotlin> = retrofitCreator.create(NewsServiceKotlin::class.java)
                .getCount("头条", count, 0, "7148e6df4677c026")
        call.enqueue(object : Callback<NewsEntityKotlin> {
            override fun onFailure(call: Call<NewsEntityKotlin>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }

            override fun onResponse(call: Call<NewsEntityKotlin>, response: Response<NewsEntityKotlin>) {
                val body: NewsEntityKotlin = response.body() ?: return
                if (count > 10) {
                    val data: List<NewData> = body.result.list
                    if (data.isEmpty()) {
                        mAdapter.setLoadState(LOADING_END)
                        return
                    }
                    mListImageUrl.addAll(data)
                    mAdapter.notifyDataSetChanged()

                } else {
                    mListImageUrl.clear()
                    mListImageUrl.addAll(body.result.list)
                    mAdapter.notifyDataSetChanged()
                    if (swipeRefreshLayout.isRefreshing) {
                        swipeRefreshLayout.isRefreshing = false
                    }
                }
            }

        })
    }

}




