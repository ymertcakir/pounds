package com.example.pounds.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pounds.repository.ProfileRepository

class ProfileViewModel( app: Application, private val profileRepository: ProfileRepository) : ViewModel() {





    open class Factory(val app : Application , private val profileRepository: ProfileRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
                return ProfileViewModel(app, profileRepository) as T
            } else {
                throw IllegalArgumentException("ViewModel is not assignable")
            }
        }
    }
}