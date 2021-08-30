package com.example.pounds.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pounds.model.Photo
import com.example.pounds.repository.AlbumDetailsRepository
import kotlinx.coroutines.launch

class PhotosViewModel( app: Application, private  val albumDetailsRepository: AlbumDetailsRepository) : ViewModel() {

    val photos: LiveData<ArrayList<Photo>> = albumDetailsRepository.photos

    init{
        getAllPhotos()
    }

    fun albumIdFromBundle(albumId:Int){
        albumDetailsRepository.setAlbumId(albumId)
    }

    private fun getAllPhotos(){
        viewModelScope.launch {
            albumDetailsRepository.filterPhotos(albumDetailsRepository.getPhotos())
        }
    }




    open class Factory( val app : Application, private val albumDetailsRepository: AlbumDetailsRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PhotosViewModel::class.java)) {
                return PhotosViewModel(app, albumDetailsRepository) as T
            } else {
                throw IllegalArgumentException("ViewModel is not assignable")
            }
        }
    }
}