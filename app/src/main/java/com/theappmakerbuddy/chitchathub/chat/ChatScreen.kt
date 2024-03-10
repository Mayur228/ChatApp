package com.theappmakerbuddy.chitchathub.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.chat.component.ReceiverMessage
import com.theappmakerbuddy.chitchathub.chat.component.SenderMessage
import com.theappmakerbuddy.chitchathub.common.model.Message
import com.theappmakerbuddy.chitchathub.contact.ContactViewModel
import com.theappmakerbuddy.chitchathub.ui.theme.primaryDark
import com.theappmakerbuddy.chitchathub.ui.theme.secondaryDark

@Composable
fun ChatScreen(
    sessionId: String?,
    viewModel: ContactViewModel = hiltViewModel()
) {

    val messages = emptyList<Message>()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryDark)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            items(messages.size) { index ->
                val message = messages[index]

                if (message.messageList.size == 0) {
                    // Sender Message
                    SenderMessage(message)

                } else {
                    // Receiver Message Content
                    ReceiverMessage(message)
                }
            }
        }

        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(14.dp)
                .clip(RoundedCornerShape(50.dp)),
            backgroundColor = secondaryDark
        ) {
            Row(
                modifier = Modifier.padding(2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(35.dp)
                        .padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.ic_add_media),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Black)
                )

                BasicTextField(
                    value = "",
                    onValueChange = {},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Send
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp, end = 8.dp)
                )

                IconButton(
                    onClick = {

                    },
                    enabled = true
                ) {
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }

            }
        }
    }
}