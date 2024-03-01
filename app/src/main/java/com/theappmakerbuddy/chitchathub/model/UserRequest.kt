package com.theappmakerbuddy.chitchathub.model

data class UserRequest(
    val username: String,
    val userProfilePhoto: String = "abc",
    val email: String,
    val phone: String,
    val password: String
)
