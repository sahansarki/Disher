package com.sahan.disher.category.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahan.disher.category.model.Category
import com.sahan.disher.category.usecase.IGetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoriesUseCase: IGetCategoriesUseCase
) : ViewModel() {

    private val _listOfCategories: MutableState<List<Category>> = mutableStateOf(emptyList())
    val listOfCategories: State<List<Category>>
        get() = _listOfCategories

    init {
        viewModelScope.launch {
            val categoriesList = getCategoriesUseCase()
            _listOfCategories.value = categoriesList.categories
        }


    }

}