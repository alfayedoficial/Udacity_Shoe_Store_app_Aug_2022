package com.alfayedoficial.shoestoreapp.ui.features.details.view

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.activityViewModels
import com.alfayedoficial.kotlinutils.KUCheckValidation.kuIsIntNumber
import com.alfayedoficial.kotlinutils.KUCheckValidation.kuValidName
import com.alfayedoficial.kotlinutils.KUConstants
import com.alfayedoficial.kotlinutils.kuRes
import com.alfayedoficial.kotlinutils.kuTakeFocus
import com.alfayedoficial.shoestoreapp.R
import com.alfayedoficial.shoestoreapp.core.common.fragment.BaseFragment
import com.alfayedoficial.shoestoreapp.databinding.FragmentDetailsBinding
import com.alfayedoficial.shoestoreapp.domain.model.ShoeModel
import com.alfayedoficial.shoestoreapp.ui.features.home.viewModel.HomeShoeViewModel
import com.alfayedoficial.shoestoreapp.utilities.setBaseActivityFragmentsToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    private val mViewModel by activityViewModels<HomeShoeViewModel>()

    override val layoutResourceLayout: Int
        get() = R.layout.fragment_details

    override fun onFragmentCreated(dataBinder: FragmentDetailsBinding) {
        dataBinder.apply {
            fragment = this@DetailsFragment
            lifecycleOwner = this@DetailsFragment

            detailsToolbar.apply { setBaseActivityFragmentsToolbar(kuRes.getString(R.string.menu_txt_main_detail_screen), toolbar, tvNameToolbar) }

        }
    }

    override fun setUpViewModelStateObservers() { println("Details Fragment") }

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
    }

    fun takeFocus() = kuTakeFocus(dataBinder.lyParent)


    fun onCancelClicked(){
        backFragment()
    }

    fun onSaveClicked(){
        if (validationInput()){
            snackBarError(getString(R.string.succesLogin) , R.color.TemplateGreen , R.color.white)
            backFragment()
        }
    }

    private fun validationInput(): Boolean {
        val name = dataBinder.etName.text.toString()
        val company = dataBinder.etCompany.text.toString()
        val size = dataBinder.etSize.text.toString()
        val dec = dataBinder.etDec.text.toString()

        val status = when{

            name.isEmpty() || company.isEmpty() || size.isEmpty() || dec.isEmpty() ->{
                if (name.isEmpty()) dataBinder.etName.error = getString(R.string.m_name_required)
                if (company.isEmpty()) dataBinder.etCompany.error = getString(R.string.m_company_required)
                if (size.isEmpty()) dataBinder.etSize.error = getString(R.string.m_size_required)
                if (dec.isEmpty()) dataBinder.etDec.error = getString(R.string.m_dec_required)
                false
            }
            !name.kuValidName() -> {
                dataBinder.etName.error = getString(R.string.m_name_invalid)
                false
            }

            !company.kuValidName() -> {
                dataBinder.etName.error = getString(R.string.m_company_invalid)
                false
            }

            !size.kuIsIntNumber() -> {
                dataBinder.etSize.error = getString(R.string.m_size_invalid)
                false
            }

            dec.length >= 250 -> {
                dataBinder.etName.error = getString(R.string.m_dec_invalid)
                false
            }

            else -> {
                mViewModel.addNewShoe(ShoeModel(name = name, company = company, size =  size.toInt(), dec =dec))
                true
            }
        }
        return status
    }


}