package com.theappmakerbuddy.chitchathub.network

import com.theappmakerbuddy.chitchathub.model.UserRequest
import com.theappmakerbuddy.chitchathub.utils.Results
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    @POST("/user")
    suspend fun registerUser(@Body userRequest: UserRequest): Results<String>
}