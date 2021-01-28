package com.example.recyclerview.network;

import java.util.List;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/5
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class WeatherEntity {
    /**
     * code : 200
     * citynm : 北京
     * cityno : beijing
     * data : [{"days":"2021-01-05","week":"星期二","temperature":"-2℃/-11℃","weather":"晴","weather_icon":"http://api.k780.com/upload/weather/d/0.gif","wind":"西南风转西北风"},{"days":"2021-01-06","week":"星期三","temperature":"-9℃/-16℃","weather":"晴","weather_icon":"http://api.k780.com/upload/weather/d/0.gif","wind":"西北风转北风"},{"days":"2021-01-07","week":"星期四","temperature":"-6℃/-14℃","weather":"晴","weather_icon":"http://api.k780.com/upload/weather/d/0.gif","wind":"西北风"},{"days":"2021-01-08","week":"星期五","temperature":"-3℃/-11℃","weather":"晴","weather_icon":"http://api.k780.com/upload/weather/d/0.gif","wind":"西北风转北风"},{"days":"2021-01-09","week":"星期六","temperature":"1℃/-9℃","weather":"晴","weather_icon":"http://api.k780.com/upload/weather/d/0.gif","wind":"北风"},{"days":"2021-01-10","week":"星期日","temperature":"1℃/-9℃","weather":"多云转晴","weather_icon":"http://api.k780.com/upload/weather/d/1.gif","wind":"北风"},{"days":"2021-01-11","week":"星期一","temperature":"1℃/-11℃","weather":"晴","weather_icon":"http://api.k780.com/upload/weather/d/0.gif","wind":"西南风"}]
     */

    private Integer code;
    private String citynm;
    private String cityno;
    private List<DataDTO> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCitynm() {
        return citynm;
    }

    public void setCitynm(String citynm) {
        this.citynm = citynm;
    }

    public String getCityno() {
        return cityno;
    }

    public void setCityno(String cityno) {
        this.cityno = cityno;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * days : 2021-01-05
         * week : 星期二
         * temperature : -2℃/-11℃
         * weather : 晴
         * weather_icon : http://api.k780.com/upload/weather/d/0.gif
         * wind : 西南风转西北风
         */

        private String days;
        private String week;
        private String temperature;
        private String weather;
        private String weatherIcon;
        private String wind;

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeatherIcon() {
            return weatherIcon;
        }

        public void setWeatherIcon(String weatherIcon) {
            this.weatherIcon = weatherIcon;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }
    }
}
