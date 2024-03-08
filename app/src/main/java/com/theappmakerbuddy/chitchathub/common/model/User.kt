package com.theappmakerbuddy.chitchathub.common.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val userId: String,
    val username: String,
    val email: String? = null,
    val phone: String? = null,
    val userProfilePhoto: String? = null
)
