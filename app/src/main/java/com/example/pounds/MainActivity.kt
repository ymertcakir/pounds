package com.example.pounds

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        navController =findNavController(R.id.nav_host_fragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navController)
        navController.addOnDestinationChangedListener { nc:NavController, nd:NavDestination, args:Bundle? ->
            when (nd.id) {
                R.id.loginFragment -> {
                    bottomNavigationView.visibility = View.GONE
                }
                R.id.albumDetailsFragment -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
                R.id.albumsFragment -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }



            }
        }


    }
}