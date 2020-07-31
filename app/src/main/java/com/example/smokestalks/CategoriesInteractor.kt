package com.example.smokestalks

import com.example.smokestalks.data.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoriesInteractor(private val categoriesRepository: CategoriesRepository) {

    suspend fun getCategories(): List<Category> = withContext(Dispatchers.IO){
        categoriesRepository.getCategories()
    }
}