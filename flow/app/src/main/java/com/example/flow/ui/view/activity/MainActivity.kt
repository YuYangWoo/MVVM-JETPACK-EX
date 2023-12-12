package com.example.flow.ui.view.activity

import com.example.flow.R
import com.example.flow.databinding.ActivityMainBinding
import com.example.library.navigation.NavigationActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : NavigationActivity<ActivityMainBinding>(R.layout.activity_main, R.id.fragmentContainerView) {

    override fun init() {
        super.init()
        setSupportActionBar(binding.toolbar)

    }

}

