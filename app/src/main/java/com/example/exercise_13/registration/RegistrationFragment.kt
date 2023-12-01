package com.example.exercise_13.registration

import androidx.fragment.app.viewModels
import com.example.exercise_13.BaseFragment
import com.example.exercise_13.databinding.FragmentRegistrationBinding


class RegistrationFragment :
    BaseFragment<FragmentRegistrationBinding>(FragmentRegistrationBinding::inflate) {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun setUp() {
        RegistrationViewModel()
        val adapter = RegistrationUnitRecyclerAdapter()
        adapter.setRegistrationUnitData(viewModel.getData())
        binding.rvRegistrationUnit.adapter = adapter

    }


}