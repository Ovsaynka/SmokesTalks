package com.example.smokestalks.data

import com.google.gson.annotations.SerializedName

class Subcategories(@SerializedName("_id")
                    val id: Int,

                    @SerializedName("name")
                    val name: String)