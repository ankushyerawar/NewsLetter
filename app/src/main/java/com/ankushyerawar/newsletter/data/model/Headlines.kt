package com.ankushyerawar.newsletter.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Headlines(
    private var status: String,
    private val totalResults: Int,
    private val articles: List<Article>? = null
)