package com.example.recyclerview.oep

/**
 * @author Xiaozh
 * @version
 * @data 2021/1/27
 * @email xiaozihuan994@qq.com
 * @description .
 */
class DiscussionData {

    companion object {

        fun getData(
                value: Int
        ): ArrayList<DiscussionEntity> {
            val dataList: ArrayList<DiscussionEntity> = ArrayList()
            for (i in 0..value) {
                val urlList = ArrayList<String>()
                urlList.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=420374887,2227334282&fm=11&gp=0.jpg")
                urlList.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1664678653,3529265069&fm=11&gp=0.jpg")
                urlList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2149406256,3250200137&fm=26&gp=0.jpg")
                urlList.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3430430301,2722469557&fm=26&gp=0.jpg")
                urlList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1915984794,3159372140&fm=26&gp=0.jpg")
                val bean = DiscussionEntity(
                        "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1350987943,2283398965&fm=26&gp=0.jpg",
                        "测试昵称",
                        "测试超长课程名称xxx测试超长课程名称xxx测试超长课程名称xxx测试超长课程名称xxx测试超长课程名称xxx测试超长课程名称xxx",
                        "具体评论内容*********具体评论内容*********具体评论内容*********具体评论内容*********具体评论内容*********具体评论内容*********",
                        "$value 分钟前",
                        value / 3,
                        3,
                        urlList
                )
                dataList.add(bean)
            }
            return dataList
        }
    }


}