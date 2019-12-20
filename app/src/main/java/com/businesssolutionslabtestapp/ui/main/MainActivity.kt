package com.businesssolutionslabtestapp.ui.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.businesssolutionslabtestapp.R
import com.businesssolutionslabtestapp.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var navHost: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigation()
    }

    private fun initNavigation() {
        navHost = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
}
