package com.example.xmlparsingrssfeedhttpurlconnections

import com.example.xmlparsingrssfeedhttpurlconnections.model.RSS
import retrofit2.Call
import retrofit2.http.GET

interface RSSAPI {

    @get:GET("svc/collections/v1/publish/https://www.nytimes.com/section/business/rss.xml")
    val feed: Call<RSS?>?
}