package com.example.recyclerview.network.kotlin

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/6
 * @email xiaozihuan994@qq.com
 * @description .
 */
data class DayWeatherEntityKotlin(
    val code: Int,
    val `data`: Data1,
    val msg: String
)

data class Data1(
    val address: String,
    val cityCode: String,
    val humidity: String,
    val reportTime: String,
    val temp: String,
    val weather: String,
    val windDirection: String,
    val windPower: String
)