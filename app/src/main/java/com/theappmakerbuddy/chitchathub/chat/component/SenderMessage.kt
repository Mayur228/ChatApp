package com.theappmakerbuddy.chitchathub.chat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.theappmakerbuddy.chitchathub.chat.Message
import com.theappmakerbuddy.chitchathub.ui.theme.primaryPurple

@Composable
fun SenderMessage(message: Message) {

    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(
                primaryPurple,
                RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
    ) {
        Text(
            text = message.messageContent,
            color = Color.White,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(text = message.time, color = Color.Gray)
    }


}