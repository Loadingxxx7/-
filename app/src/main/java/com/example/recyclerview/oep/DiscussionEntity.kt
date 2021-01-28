package com.example.recyclerview.oep

import java.io.Serializable

/**
 * @author Xiaozh
 * @version
 * @data 2021/1/26
 * @email xiaozihuan994@qq.com
 * @description .
 */
data class DiscussionEntity(
        val userIconURL: String,
        val userName: String,
        val courseName: String,
        val content: String,
        val time: String,
        var likeNum: Int,
        val commentNum: Int,
        val urls: ArrayList<String>
):Serializable