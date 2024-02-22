package com.example.chatapp.chat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.chatapp.chat.Message
import com.example.chatapp.ui.theme.secondaryDark

@Composable
fun ReceiverMessage(message: Message) {
    Column(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(
                secondaryDark.copy(alpha = 0.8f),
                RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.End,
    ) {
        Text(
            text = message.messageContent,
            color = Color.White,
            textAlign = TextAlign.End,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(text = message.time, color = Color.Gray, textAlign = TextAlign.End)
    }
}