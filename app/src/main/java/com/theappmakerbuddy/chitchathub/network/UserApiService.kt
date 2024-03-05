package com.theappmakerbuddy.chitchathub.network

import com.theappmakerbuddy.chitchathub.model.UpdateUserDetailsRequest
import com.theappmakerbuddy.chitchathub.model.UserRequest
import com.theappmakerbuddy.chitchathub.utils.Results
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    suspend fun registerUser(@Body userRequest: UserRequest): Results<String>

    suspend fun loginWithEmail(email: String): Results<String>

    suspend fun loginWithPhone(phone: String): Results<String>

    suspend fun loginWithUsername(username: String, password:String): Results<String>

    suspend fun changePassword(password: String,username:String): Results<String>

    suspend fun updateUserProfile(@Body userProfile: String): Results<String>

    suspend fun updateUserDetails(@Body updateUserDetailsRequest: UpdateUserDetailsRequest): Results<String>

    suspend fun deleteUser(userId: String): Results<String>

}