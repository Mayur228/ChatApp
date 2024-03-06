package com.theappmakerbuddy.chitchathub.model

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
    val username: String,
    val userProfilePhoto: String = "abc",
    val email: String,
    val phone: String,
    val password: String
)
