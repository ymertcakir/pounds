package com.example.pounds.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("albumId")
    val albumId :Int,
    @SerializedName("name")
    val name : Int,
    @SerializedName("title")
    val title : String,
    @SerializedName("url")
    val url : String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl : String

)