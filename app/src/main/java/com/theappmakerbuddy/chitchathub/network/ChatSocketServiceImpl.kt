package com.theappmakerbuddy.chitchathub.network

import com.theappmakerbuddy.chitchathub.common.model.Message
import com.theappmakerbuddy.chitchathub.utils.Constant.CHAT
import com.theappmakerbuddy.chitchathub.utils.Results
import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.client.request.url
import io.ktor.websocket.Frame
import io.ktor.websocket.WebSocketSession
import io.ktor.websocket.close
import io.ktor.websocket.readText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.isActive
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ChatSocketServiceImpl @Inject constructor(private val httpClient: HttpClient): ChatSocketService {

    private var socket: WebSocketSession? = null

    override suspend fun initSession(
        userId: String,
        username: String,
        userPP: String,
        sessionId: String
    ): Results<Unit> {
        return try {
            socket = httpClient.webSocketSession {
                url("${CHAT}?sessionId=$sessionId")
            }
            if(socket?.isActive == true) {
                Results.Success(Unit)
            } else Results.Error("Couldn't establish a connection.")
        } catch(e: Exception) {
            e.printStackTrace()
            Results.Error(e.localizedMessage ?: "Unknown error")
        }
    }

    override suspend fun sendMessage(message: String) {
        try {
            socket?.send(Frame.Text(message))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun observeMessages(): Flow<Message> {
        return try {
            socket?.incoming
                ?.receiveAsFlow()
                ?.filter { it is Frame.Text }
                ?.map {
                    val json = (it as? Frame.Text)?.readText() ?: ""
                    val messageDto = Json.decodeFromString<Message>(json)
                    messageDto
                } ?: flow {  }
        } catch(e: Exception) {
            e.printStackTrace()
            flow {  }
        }
    }

    override suspend fun closeSession() {
        socket?.close()
    }
}