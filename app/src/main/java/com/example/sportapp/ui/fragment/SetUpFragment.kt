package com.example.sportapp.ui.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sportapp.R
import com.example.sportapp.ui.activity.main.MainVm
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_set_up.*

@AndroidEntryPoint

class SetUpFragment : Fragment(R.layout.fragment_set_up) {
    val viewModel: MainVm by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvContinue.setOnClickListener {
            findNavController().navigate(R.id.action_setUpFragment_to_RunFragment)
        }

    }
}