package com.example.pounds.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class LoginViewModel(app:Application) : ViewModel() {


    open class Factory(val app : Application ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                return LoginViewModel(app) as T
            } else {
                throw IllegalArgumentException("ViewModel is not assignable")
            }
        }
    }

    companion object {
        const val LOGO_URL= "https://pngimage.net/wp-content/uploads/2018/05/dummy-logo-png-1.png"
    }
}