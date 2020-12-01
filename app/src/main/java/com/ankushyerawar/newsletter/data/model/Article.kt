package com.ankushyerawar.newsletter.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Article(

    @SerializedName("source")
    @Expose
    private var source: Source,

    @SerializedName("author")
    @Expose
    private val author: String,

    @SerializedName("title")
    @Expose
    private val title: String,

    @SerializedName("description")
    @Expose
    private val description: String,

    @SerializedName("url")
    @Expose
    private val url: String,

    @SerializedName("urlToImage")
    @Expose
    private val urlToImage: String,

    @SerializedName("publishedAt")
    @Expose
    private val publishedAt: String,

    @SerializedName("content")
    @Expose
    private val content: String
)