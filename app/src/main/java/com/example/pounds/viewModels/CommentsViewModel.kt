package com.example.pounds.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pounds.model.Comment
import com.example.pounds.repository.AlbumDetailsRepository
import kotlinx.coroutines.launch

class CommentsViewModel(app: Application, private  val albumDetailsRepository: AlbumDetailsRepository) : ViewModel() {
    val comments: LiveData<ArrayList<Comment>> = albumDetailsRepository.comments
    init {
        getAllComments()
    }


    fun albumIdFromBundlee(albumId:Int){
        albumDetailsRepository.setAlbumId(albumId)
    }

    private fun getAllComments(){
        viewModelScope.launch {
            albumDetailsRepository.filterComments(albumDetailsRepository.getComments())
        }
    }



    open class Factory(val app : Application, private val albumDetailsRepository: AlbumDetailsRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CommentsViewModel::class.java)) {
                return CommentsViewModel(app, albumDetailsRepository) as T
            } else {
                throw IllegalArgumentException("ViewModel is not assignable")
            }
        }
    }
}