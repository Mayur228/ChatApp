package com.theappmakerbuddy.chitchathub.network

import com.theappmakerbuddy.chitchathub.model.UserRequest
import com.theappmakerbuddy.chitchathub.utils.Constant.REGISTER_USER_API
import com.theappmakerbuddy.chitchathub.utils.Results
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.util.InternalAPI
import javax.inject.Inject

class UserApiServiceImpl @Inject constructor(private val httpClient: HttpClient): UserApiService {
    @OptIn(InternalAPI::class)
    override suspend fun registerUser(userRequest: UserRequest): Results<String> {
        return try {
            httpClient.post {
                url(REGISTER_USER_API)
                body = userRequest
            }
            Results.Success("Congratulations, Welcome to ChitChat Hub Your account has been successfully created.")
        }catch (e: Exception){
            Results.Error(e)
        }
    }
}