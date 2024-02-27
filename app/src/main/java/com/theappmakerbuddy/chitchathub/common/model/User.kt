package com.theappmakerbuddy.chitchathub.common.model

data class User(
    val userId: String,
    val userName: String,
    val email: String? = null,
    val phone: String? = null,
    val password: String,
    val userProfile: String? = null
)
