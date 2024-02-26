package com.example.chatapp.home.model


data class ChatList(
    val chatList: List<ChatData>
)
data class ChatData(
    val userProfile: String,
    val userName: String,
    val userMessage: String,
    val unReadMessageCount: Int,
    val messageTime: String
)
