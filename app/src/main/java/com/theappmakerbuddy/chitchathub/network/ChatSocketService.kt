package com.theappmakerbuddy.chitchathub.network

import com.theappmakerbuddy.chitchathub.common.model.Message
import com.theappmakerbuddy.chitchathub.utils.Results
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {
    suspend fun initSession(
//        userId: String,
//        username: String,
//        userPP: String,
        sessionId: String
    ): Results<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()


}