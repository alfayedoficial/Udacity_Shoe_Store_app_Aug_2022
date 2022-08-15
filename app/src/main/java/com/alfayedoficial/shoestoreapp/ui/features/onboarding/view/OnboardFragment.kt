package com.alfayedoficial.shoestoreapp.ui.features.onboarding.view

import com.alfayedoficial.kotlinutils.KUConstants
import com.alfayedoficial.shoestoreapp.R
import com.alfayedoficial.shoestoreapp.core.common.fragment.BaseFragment
import com.alfayedoficial.shoestoreapp.databinding.FragmentOnboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardFragment : BaseFragment<FragmentOnboardBinding>() {

    override val layoutResourceLayout: Int
        get() = R.layout.fragment_onboard

    override fun onFragmentCreated(dataBinder: FragmentOnboardBinding) {
        dataBinder.apply {
            fragment = this@OnboardFragment
            lifecycleOwner = this@OnboardFragment
        }
    }

    override fun setUpViewModelStateObservers() {println("onboard fragment") }

    fun onBoardingClicked(){
        appPreferences.setValue(KUConstants.KU_IS_WIZARD, true)
        navController.navigate(R.id.action_onboardFragment_to_instructionsFragment)
    }

}