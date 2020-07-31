package com.example.smokestalks.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category (
    @SerializedName("_id")
    val id: Int?,
    @SerializedName("name")
    val name: String?/*,
    @SerializedName("subcategories")
    val subcategories: List<Subcategories>?*/
): Serializable