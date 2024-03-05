package com.theappmakerbuddy.chitchathub.model

data class UpdateUserDetailsRequest(
    val username: String,
    val email: String,
    val phone: String
)
