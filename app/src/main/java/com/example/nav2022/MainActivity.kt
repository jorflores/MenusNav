package com.example.nav2022

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import com.example.nav2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
           navController = navHostFragment.navController





        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId) {

            R.id.home_menu_item -> {
                navController.navigate(R.id.home_menu_item)
                true
            }
             R.id.a_menu -> {
                 navController.navigate(R.id.fragmentA)
                 true
             }
                R.id.b_menu -> {
                    navController.navigate(R.id.fragmentB)
                    true
                }


                else -> false


            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.my_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)

    }


}