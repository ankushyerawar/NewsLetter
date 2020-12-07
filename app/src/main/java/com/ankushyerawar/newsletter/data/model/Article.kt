package com.ankushyerawar.newsletter.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Article(
    private var source: Source,
    private val author: String,
    private val title: String,
    private val description: String,
    private val url: String,
    private val urlToImage: String,
    private val publishedAt: String,
    private val content: String
)