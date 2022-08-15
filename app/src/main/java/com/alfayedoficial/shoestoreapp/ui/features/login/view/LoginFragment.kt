package com.alfayedoficial.shoestoreapp.ui.features.login.view

import com.alfayedoficial.kotlinutils.KUConstants
import com.alfayedoficial.kotlinutils.kuTakeFocus
import com.alfayedoficial.shoestoreapp.R
import com.alfayedoficial.shoestoreapp.core.common.fragment.BaseFragment
import com.alfayedoficial.shoestoreapp.databinding.FragmentLoginBinding
import com.alfayedoficial.shoestoreapp.utilities.ValidationInputs.validationAuthTextInputEditText
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {


    fun takeFocus(){
        kuTakeFocus(dataBinder.lyParent)
    }

    fun onLoginClicked() {
        dataBinder.apply {
            if (validationAuthTextInputEditText(Pair(1, emailEt), Pair(2, passwordEt))) {
                navigate()
            }
        }
    }

    fun onLoginWithAnExistingAccountClicked(){
        navigate()
    }

    private fun navigate(){
        appPreferences.setValue(KUConstants.KU_IS_LOGIN, true)
        navController.navigate(R.id.action_loginFragment_to_onboardFragment)
    }


    override val layoutResourceLayout: Int
        get() = R.layout.fragment_login

    override fun onFragmentCreated(dataBinder: FragmentLoginBinding) {
        dataBinder.apply {
            fragment = this@LoginFragment
            lifecycleOwner = this@LoginFragment
        }
    }

    override fun setUpViewModelStateObservers() { println("login fragment")}
}