package com.example.smokestalks.data

import java.util.*

data class User(val phoneNumber: Number,
                val name: String,
                val surname: String,
                val email: String,
                val birthday: Date,
                val gender:String,
                val city: String)