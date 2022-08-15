package com.alfayedoficial.shoestoreapp.ui.features.instructions.view

import com.alfayedoficial.shoestoreapp.R
import com.alfayedoficial.shoestoreapp.core.common.fragment.BaseFragment
import com.alfayedoficial.shoestoreapp.databinding.FragmentInstructionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InstructionsFragment : BaseFragment<FragmentInstructionsBinding>() {

    override val layoutResourceLayout: Int
        get() = R.layout.fragment_instructions

    override fun onFragmentCreated(dataBinder: FragmentInstructionsBinding) {
        dataBinder.apply {
            fragment = this@InstructionsFragment
            lifecycleOwner =this@InstructionsFragment
        }
    }

    override fun setUpViewModelStateObservers() {println("Instructions fragment") }

    fun introductionsClicked(){
        navController.navigate(R.id.action_instructionsFragment_to_homeFragment)
    }
}