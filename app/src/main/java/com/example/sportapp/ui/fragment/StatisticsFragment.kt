package com.example.sportapp.ui.fragment


import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportapp.R
import com.example.sportapp.ui.activity.main.MainVm
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statics) {
    val viewModel: StatisticsVm by viewModels()

}