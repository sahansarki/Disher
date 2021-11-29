package com.sahan.disher.category.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahan.disher.category.usecase.IGetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    //USECASE
    useCase: IGetCategoriesUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            val a = useCase()
            Log.d("BK",a)
        }


    }

}