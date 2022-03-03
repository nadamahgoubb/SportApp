package com.example.sportapp.ui.fragment

import androidx.lifecycle.ViewModel
import com.example.sportapp.data.repositorty.Repository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class StatisticsVm  @Inject constructor(val repository: Repository) :ViewModel(){

}
