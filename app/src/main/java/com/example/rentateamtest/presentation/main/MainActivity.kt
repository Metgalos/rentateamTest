package com.example.rentateamtest.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import com.example.rentateamtest.R
import com.example.rentateamtest.databinding.ActivityMainBinding
import com.example.rentateamtest.presentation.about.AboutFragmentDirections
import com.example.rentateamtest.presentation.users.UsersFragmentDirections
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    private val navigationListener by lazy {
        NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.list_of_user -> navController.navigate(
                    UsersFragmentDirections.actionGlobalUsersFragment()
                )
                R.id.about_app -> navController.navigate(
                    AboutFragmentDirections.actionGlobalAboutFragment()
                )
                else -> return@OnItemSelectedListener false
            }
            return@OnItemSelectedListener true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainNavigation.setOnItemSelectedListener(navigationListener)
    }
}