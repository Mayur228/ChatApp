package com.theappmakerbuddy.chitchathub.network

import com.theappmakerbuddy.chitchathub.model.UpdateUserDetailsRequest
import com.theappmakerbuddy.chitchathub.model.UserRequest
import com.theappmakerbuddy.chitchathub.utils.Constant.CHANGE_PASSWORD
import com.theappmakerbuddy.chitchathub.utils.Constant.LOGIN_WITH_EMAIL
import com.theappmakerbuddy.chitchathub.utils.Constant.LOGIN_WITH_PHONE
import com.theappmakerbuddy.chitchathub.utils.Constant.LOGIN_WITH_USERNAME
import com.theappmakerbuddy.chitchathub.utils.Constant.REGISTER_USER_API
import com.theappmakerbuddy.chitchathub.utils.Constant.UPDATE_USER_PROFILE
import com.theappmakerbuddy.chitchathub.utils.Results
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import javax.inject.Inject

class UserApiServiceImpl @Inject constructor(private val httpClient: HttpClient): UserApiService {
    @OptIn(InternalAPI::class)
    override suspend fun registerUser(userRequest: UserRequest): Results<String> {
        return try {
            httpClient.post {
                url(REGISTER_USER_API)
                contentType(ContentType.Application.Json)
                body = userRequest
            }
            Results.Success("Congratulations, Welcome to ChitChat Hub Your account has been successfully created.")
        }catch (e: Exception){
            Results.Error(e)
        }
    }
    override suspend fun loginWithEmail(email: String): Results<String> {
        return try {
            httpClient.get {
                url(LOGIN_WITH_EMAIL)
                parameter("email",email)
            }
            Results.Success("User Login Successful")
        }catch (e: Exception){
            Results.Error(e)
        }
    }

    override suspend fun loginWithPhone(phone: String): Results<String> {
        return try {
            httpClient.get {
                url(LOGIN_WITH_PHONE)
                parameter("phone",phone)
            }
            Results.Success("User Login Successful")
        }catch (e: Exception){
            Results.Error(e)
        }
    }

    override suspend fun loginWithUsername(username: String, password: String): Results<String> {
        return try {
            httpClient.get {
                url(LOGIN_WITH_USERNAME)
                parameter("username",username)
                parameter("password",password)
            }
            Results.Success("User Login Successful")
        }catch (e: Exception){
            Results.Error(e)
        }
    }

    override suspend fun changePassword(password: String,username:String): Results<String> {
        return try {
            httpClient.get {
                url(CHANGE_PASSWORD)
                parameter("password",password)
                parameter("username",username)
            }
            Results.Success("Password changed Successfully")
        }catch (e: Exception){
            Results.Error(e)
        }
    }

    @OptIn(InternalAPI::class)
    override suspend fun updateUserProfile(userProfile: String): Results<String> {
        return try {
            httpClient.post {
                url(UPDATE_USER_PROFILE)
                body = userProfile
            }
            Results.Success("Profile photo Successfully Changed")
        }catch (e: Exception){
            Results.Error(e)
        }
    }

    @OptIn(InternalAPI::class)
    override suspend fun updateUserDetails(updateUserDetailsRequest: UpdateUserDetailsRequest): Results<String> {
        return try {
            httpClient.post {
                url(UPDATE_USER_PROFILE)
                body = updateUserDetailsRequest
            }
            Results.Success("Profile details Successfully updated")
        }catch (e: Exception){
            Results.Error(e)
        }
    }

    override suspend fun deleteUser(userId: String): Results<String> {
        return try {
            httpClient.get {
                url(CHANGE_PASSWORD)
                parameter("userID",userId)
            }
            Results.Success("Password changed Successfully")
        }catch (e: Exception){
            Results.Error(e)
        }
    }
}