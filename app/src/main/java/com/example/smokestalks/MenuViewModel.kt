package com.example.smokestalks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smokestalks.data.Category
import kotlinx.coroutines.launch

class MenuViewModel(private val interactor: CategoriesInteractor): ViewModel() {

    private val categories = MutableLiveData<List<Category>>()
    fun categories() = categories as LiveData<List<Category>>

    init{
        viewModelScope.launch {
            val categoriesResponse = interactor.getCategories()
            categories.value = categoriesResponse
        }
    }
}
