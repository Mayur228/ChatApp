package com.theappmakerbuddy.chitchathub.registration.repository

import android.util.Log
import com.theappmakerbuddy.chitchathub.model.UpdateUserDetailsRequest
import com.theappmakerbuddy.chitchathub.model.UserRequest
import com.theappmakerbuddy.chitchathub.network.UserApiService
import com.theappmakerbuddy.chitchathub.utils.Results
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserApiService
) {
    suspend fun registerUser(userRequest: UserRequest): Results<String> {
        return userService.registerUser(userRequest)
    }

    suspend fun loginUserWithEmail(email: String): Results<String> {
        return userService.loginWithEmail(email)
    }
    suspend fun loginUserWithPhone(phone: String): Results<String> {
        return userService.loginWithPhone(phone)
    }

    suspend fun loginUserWithUsername(username:String,password: String): Results<String> {
        return userService.loginWithUsername(username, password)
    }

    suspend fun updateUserProfile(userProfile: String): Results<String> {
        return userService.updateUserProfile(userProfile)
    }
    suspend fun updateUserDetails(userDetailsRequest: UpdateUserDetailsRequest): Results<String> {
        return userService.updateUserDetails(userDetailsRequest)
    }

    suspend fun changePassword(username: String,password: String): Results<String> {
        return userService.changePassword(password, username)
    }

    suspend fun deleteUser(userId: String): Results<String> {
        return userService.deleteUser(userId)
    }
}