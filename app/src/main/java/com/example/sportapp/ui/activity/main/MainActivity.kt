package com.example.sportapp.ui.activity.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.sportapp.R
import com.example.sportapp.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())

        navHostFragment.findNavController().addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.setUpFragment, R.id.trackingFragment ->
                    bottomNavigationView.visibility = View.GONE
                else ->
                    bottomNavigationView.visibility = View.VISIBLE

            }
        }
    }

    fun navigateToTrakingFragment(intent: Intent) {
        if (intent.action == Constant.ACTION_SHOW_TRACKING_FRAGMENT) {
    navHostFragment.findNavController().navigate(R.id.action_launch_tracking_fragment)
        }

    }
}