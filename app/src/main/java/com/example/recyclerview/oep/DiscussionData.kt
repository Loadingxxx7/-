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
                urlList.add("https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/3c6d55fbb2fb4316f58cd08820a4462308f7d3b5.jpg")
                urlList.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201601%2F27%2F213216yockawscpoa4ukza.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614417609&t=ed15ecb0833865b217eb76a5c6c7cef3")
                urlList.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201505%2F01%2F192241f80ccs8o0xgc405k.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614417609&t=39401da17c992a66a203272b6f06c460")
                urlList.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2F01.minipic.eastday.com%2F20171009%2F20171009093228_d41d8cd98f00b204e9800998ecf8427e_3.jpeg&refer=http%3A%2F%2F01.minipic.eastday.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614417609&t=bdc6b48bf8163b92d4f8099ce5ce756d")
                urlList.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201208%2F23%2F210118yj0xkkpybiqvqvpy.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614417609&t=4681dfc20a213810cefb403fd5010485")
                urlList.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201505%2F01%2F192152o9mqcumbqs6b6etz.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614417609&t=31191465bcc0bd2464c53c5520c4322f")

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