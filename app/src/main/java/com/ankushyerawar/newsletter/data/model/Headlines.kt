package com.ankushyerawar.newsletter.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Headlines(

    @SerializedName("status")
    @Expose
    private var status: String,

    @SerializedName("totalResults")
    @Expose
    private val totalResults: Int,

    @SerializedName("articles")
    @Expose
    private val articles: List<Article>? = null
)