package com.theappmakerbuddy.chitchathub.common.model

data class Chat(
    val chatList: List<ChatData>
)

data class ChatData(
    val userId: String,
    val userName: String,
    val userProfile: String,
    val isMessageRead: Boolean,
    val lastMessage: String,
    val messageCount: Int,
    val time: String
)
