package com.ankushyerawar.newsletter.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    @Expose
    private var id: String,
    @SerializedName("name")
    @Expose
    private val name: String
)