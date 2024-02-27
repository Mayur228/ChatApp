package com.theappmakerbuddy.chitchathub.common.model

import java.util.Date

data class Message(
    val messageList: List<MessageData>
)

data class MessageData(
    val senderId: String,
    val receiverId: String,
    val senderName: String,
    val senderUserProfile: String,
    val message:String,
    val messageType: MessageType,
    val time: Date,
    val isMessageRead: Boolean,
)
