package com.example.pounds.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pounds.api.RetrofitInstance
import com.example.pounds.model.Comment
import com.example.pounds.model.Photo

class AlbumDetailsRepository {
    private val _photos: MutableLiveData<ArrayList<Photo>> = MutableLiveData()
    val photos: LiveData<ArrayList<Photo>> = _photos

    private val _comments: MutableLiveData<ArrayList<Comment>> = MutableLiveData()
    val comments: LiveData<ArrayList<Comment>> = _comments

    private val _albumId: MutableLiveData<Int> = MutableLiveData()
    val albumId:LiveData<Int> = _albumId

    suspend fun getPhotos(): ArrayList<Photo>{
        return RetrofitInstance.api.getPhotos()
    }
    suspend fun getComments(): ArrayList<Comment>{
        return RetrofitInstance.api.getComments()
    }
    fun setAlbumId(albumId: Int){
        _albumId.value = albumId

    }


    fun filterPhotos(list: ArrayList<Photo>){


        _photos.value= list.filter {albumId.value==it.albumId } as ArrayList<Photo>


    }
    fun filterComments(list: ArrayList<Comment>){
        _comments.value= list.filter { albumId.value==it.postId } as ArrayList<Comment>
        Log.i("filterr", " ${list}")
        Log.i("filterr", " ${albumId.value}")

        Log.i("filterr", " ${_photos.value}")

    }





}