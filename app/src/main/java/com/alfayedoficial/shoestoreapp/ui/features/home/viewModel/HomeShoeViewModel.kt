package com.alfayedoficial.shoestoreapp.ui.features.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alfayedoficial.shoestoreapp.domain.model.ShoeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeShoeViewModel @Inject constructor() : ViewModel() {

    private val _shoesMutableLiveData = MutableLiveData<MutableList<ShoeModel>>(mutableListOf())
    val shoesLiveData: LiveData<MutableList<ShoeModel>>
        get() = _shoesMutableLiveData

    fun addNewShoe(shoeModel: ShoeModel) {
        _shoesMutableLiveData.value = (_shoesMutableLiveData.value ?: mutableListOf()).apply {
            add(shoeModel)
        }
    }

}