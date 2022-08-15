package com.alfayedoficial.shoestoreapp.ui.features.home.view

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.activityViewModels
import com.alfayedoficial.kotlinutils.KUConstants
import com.alfayedoficial.kotlinutils.kuGetBindingDialog
import com.alfayedoficial.kotlinutils.kuRes
import com.alfayedoficial.shoestoreapp.R
import com.alfayedoficial.shoestoreapp.core.common.fragment.BaseFragment
import com.alfayedoficial.shoestoreapp.databinding.FragmentHomeBinding
import com.alfayedoficial.shoestoreapp.databinding.ItemLyShoeBinding
import com.alfayedoficial.shoestoreapp.ui.features.home.viewModel.HomeShoeViewModel
import com.alfayedoficial.shoestoreapp.utilities.setBaseActivityFragmentsToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val mViewModel by activityViewModels<HomeShoeViewModel>()

    override val layoutResourceLayout: Int
        get() = R.layout.fragment_home

    override fun onFragmentCreated(dataBinder: FragmentHomeBinding) {
        dataBinder.apply {
            fragment = this@HomeFragment
            lifecycleOwner = this@HomeFragment

            homeToolbar.apply { setBaseActivityFragmentsToolbar(kuRes.getString(R.string.menu_txt_main_screen), toolbar, tvNameToolbar) }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.header_menu_dashboard, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId ){
            R.id.menuLogOut -> requestLogout()
        }
        return true
    }

    private fun requestLogout() {
        appPreferences.removeKey(KUConstants.KU_IS_LOGIN)
        navController.navigate(R.id.action_homeFragment_to_loginFragment)
    }

    override fun setUpViewModelStateObservers() {
        mViewModel.shoesLiveData.observe(viewLifecycleOwner) {shoes ->
            for (item in shoes) {
                val lyShoeBinding = kuGetBindingDialog(layoutInflater, R.layout.item_ly_shoe) as ItemLyShoeBinding
                lyShoeBinding.model = item
                dataBinder.lyListShoes.addView(lyShoeBinding.root)
            }
        }
    }

    fun onAddShoeClick() = navController.navigate(R.id.action_homeFragment_to_detailsFragment)

}