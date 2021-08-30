package com.example.pounds.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.pounds.model.Album
import com.example.pounds.repository.AlbumsRepository
import com.example.pounds.repository.ProfileRepository
import kotlinx.coroutines.launch


class AlbumsViewModel(app: Application, private val  albumsRepository: AlbumsRepository) : ViewModel() {
    val albums: LiveData<ArrayList<Album>> = albumsRepository.albums

    init {
        getAllAlbums()
    }

    private fun getAllAlbums(){
        viewModelScope.launch {
            albumsRepository.submitAlbum( albumsRepository.getAlbums())
        }
    }






    open class Factory(val app : Application , private val albumsRepository: AlbumsRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlbumsViewModel::class.java)) {
                return AlbumsViewModel(app, albumsRepository) as T
            } else {
                throw IllegalArgumentException("ViewModel is not assignable")
            }
        }
    }
}