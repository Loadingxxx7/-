package com.example.recyclerview.network.kotlin

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/5
 * @email xiaozihuan994@qq.com
 * @description .
 */
data class NewsEntityKotlin(
    val msg: String,
    val result: Result,
    val status: Int
)

data class Result(
    val channel: String,
    val list: List<NewData>,
    val num: String
)

data class NewData(
    val category: String,
    val content: String,
    val pic: String,
    val src: String,
    val time: String,
    val title: String,
    val url: String,
    val weburl: String
)