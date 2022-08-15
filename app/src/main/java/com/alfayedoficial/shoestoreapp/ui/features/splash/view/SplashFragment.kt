package com.alfayedoficial.shoestoreapp.ui.features.splash.view

import com.alfayedoficial.kotlinutils.KUExtensionsApp
import com.alfayedoficial.kotlinutils.kuRunDelayed
import com.alfayedoficial.shoestoreapp.R
import com.alfayedoficial.shoestoreapp.core.common.fragment.BaseFragment
import com.alfayedoficial.shoestoreapp.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override val layoutResourceLayout: Int
        get() = R.layout.fragment_splash

    override fun onFragmentCreated(dataBinder: FragmentSplashBinding) {
        dataBinder.apply {
            fragment = this@SplashFragment
            lifecycleOwner = this@SplashFragment

            kuRunDelayed(2000) {
                if (!KUExtensionsApp.kuIsLogin(appPreferences)){
                    navController.navigate(R.id.action_splashFragment_to_loginFragment)
                }else if (!KUExtensionsApp.kuIsWizard(appPreferences)){
                    navController.navigate(R.id.action_splashFragment_to_onboardFragment)
                }else{
                   navController.navigate(R.id.action_splashFragment_to_homeFragment)
                }
            }
        }
    }

    override fun setUpViewModelStateObservers() { println("Splash Fragment") }


}