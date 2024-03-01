package com.theappmakerbuddy.chitchathub.registration.repository

import android.util.Log
import com.theappmakerbuddy.chitchathub.model.UserRequest
import com.theappmakerbuddy.chitchathub.network.UserApiService
import com.theappmakerbuddy.chitchathub.utils.Results
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserApiService
) {
    suspend fun registerUser(userRequest: UserRequest): Results<String> {
        return try{
            val response = userService.registerUser(userRequest)
            Log.e("SUCCESS",response.toString())
            Results.Success("Congratulations, Welcome to ChitChat Hub Your account has been successfully created.")
        }catch(e: Exception)  {
            Results.Error(e)
        }
    }
}