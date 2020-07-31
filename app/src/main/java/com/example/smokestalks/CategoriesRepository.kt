package com.example.smokestalks

import androidx.annotation.WorkerThread
import com.example.smokestalks.data.APIService
import com.example.smokestalks.data.Category
import com.example.smokestalks.data.NetworkService

interface CategoriesRepository{
    @WorkerThread
    fun getCategories(): List<Category>
}

class CategoriesRepositoryImpl(private val service: APIService): CategoriesRepository {

    @WorkerThread
    override fun getCategories(): List<Category> =
        service.getCategories().execute().body().orEmpty()

}