package com.theappmakerbuddy.chitchathub.network

import android.util.Log
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
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import java.net.URLDecoder
import java.net.URLEncoder
import javax.inject.Inject

class UserApiServiceImpl @Inject constructor(private val httpClient: HttpClient): UserApiService {
    override suspend fun registerUser(userRequest: UserRequest): Results<String> {
        return try {

           val response =  httpClient.post(REGISTER_USER_API){
                setBody(userRequest)
            }

            if(response.status == HttpStatusCode.Created){
                Results.Success("Congratulations, Welcome to ChitChat Hub Your account has been successfully created.")
            }else {
                Results.Error(response.toString())
            }

        }catch (e: Exception){
            Results.Error(e.message.toString())
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
            Results.Error(e.message.toString())
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
            Results.Error(e.message.toString())
        }
    }

    override suspend fun loginWithUsername(username: String, password: String): Results<String> {
        return try {

            Log.e("CHECK",password)
            val response =  httpClient.get("${LOGIN_WITH_USERNAME}/${username}/${password}")

            if(response.status == HttpStatusCode.OK){
                Results.Success("User Login Successful")
            }else {
                Results.Error(response.toString())
            }

        }catch (e: Exception){
            Results.Error(e.message.toString())
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
            Results.Error(e.message.toString())
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
            Results.Error(e.message.toString())
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
            Results.Error(e.message.toString())
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
            Results.Error(e.message.toString())
        }
    }
}