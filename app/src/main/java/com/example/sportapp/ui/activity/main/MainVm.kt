package com.example.sportapp.ui.activity.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.sportapp.data.repositorty.Repository
import javax.inject.Inject

class MainVm @ViewModelInject constructor(val repository: Repository) : ViewModel() {


}