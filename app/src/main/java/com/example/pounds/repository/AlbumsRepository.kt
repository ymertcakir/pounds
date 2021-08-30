package com.example.pounds.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pounds.api.RetrofitInstance
import com.example.pounds.model.Album
import kotlinx.coroutines.*

class AlbumsRepository{
private val _albums: MutableLiveData<ArrayList<Album>> = MutableLiveData()
val albums: LiveData<ArrayList<Album>> = _albums

    suspend fun getAlbums(): ArrayList<Album> {
      return  RetrofitInstance.api.getAlbums()
    }
    fun submitAlbum(list: ArrayList<Album>){
        _albums.value= list

    }









}

/*
   Responselu alip veri geldi mi gelmedi mi denetlemeye calistim ama olmadi ne yazik ki



    var job: Job? = null
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

   private fun getAlbum(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch{
            val response = RetrofitInstance.api?.getAlbums()
            withContext(Dispatchers.Main){
                if (response?.isSuccessful == true){
                    _albums.value = response.body()



                }else{
                    onError("Error : Album cant find ")
                }
            }
        }
    }
    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }*/


