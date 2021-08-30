package com.example.pounds.api

import com.example.pounds.model.Album
import com.example.pounds.model.Comment
import com.example.pounds.model.Photo
import retrofit2.http.GET
import retrofit2.Response


interface AlbumApi {
    @GET("albums")
    suspend fun getAlbums():ArrayList<Album>
    @GET("photos")
    suspend fun getPhotos(): ArrayList<Photo>
    @GET("comments")
    suspend fun getComments(): ArrayList<Comment>
}