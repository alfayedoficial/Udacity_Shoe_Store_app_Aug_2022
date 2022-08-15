package com.alfayedoficial.shoestoreapp.ui.features.home.view

import androidx.fragment.app.activityViewModels
import com.alfayedoficial.kotlinutils.kuGetBindingDialog
import com.alfayedoficial.shoestoreapp.R
import com.alfayedoficial.shoestoreapp.core.common.fragment.BaseFragment
import com.alfayedoficial.shoestoreapp.databinding.FragmentHomeBinding
import com.alfayedoficial.shoestoreapp.databinding.ItemLyShoeBinding
import com.alfayedoficial.shoestoreapp.ui.features.home.viewModel.HomeShoeViewModel
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
        }
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