package com.theappmakerbuddy.chitchathub.chat.component

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
import com.theappmakerbuddy.chitchathub.common.model.MessageData
import com.theappmakerbuddy.chitchathub.ui.theme.secondaryDark

@Composable
fun ReceiverMessage(message: MessageData) {
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
            text = "1",
            color = Color.White,
            textAlign = TextAlign.End,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(text = message.time.toString(), color = Color.Gray, textAlign = TextAlign.End)
    }
}