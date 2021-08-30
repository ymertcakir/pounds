package com.example.pounds.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pounds.repository.AlbumDetailsRepository

class AlbumDetailsViewModel(val albumId:Int,
                            app: Application,
                            private val albumDetailsRepository: AlbumDetailsRepository) : ViewModel() {



    open class Factory(val albumId: Int, val app : Application, private val albumDetailsRepository: AlbumDetailsRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlbumDetailsViewModel::class.java)) {
                return AlbumDetailsViewModel(albumId,app, albumDetailsRepository) as T
            } else {
                throw IllegalArgumentException("ViewModel is not assignable")
            }
        }
    }
}