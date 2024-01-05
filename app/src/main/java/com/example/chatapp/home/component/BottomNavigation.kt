package com.example.chatapp.home.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatapp.R
import com.example.chatapp.home.MessageContent

sealed class BottomNavigationScreens(
    val title: String,
    val icon: Int,
    val screenContent: @Composable (Modifier: Modifier) -> Unit
) {
    object Message : BottomNavigationScreens(
        "Message",
        R.drawable.chat_icon,
        { Modifier ->
            MessageContent(Modifier)
//            Text("Calls Screen", modifier = Modifier)
        }
    )

    object Calls : BottomNavigationScreens(
        "Calls",
        R.drawable.call_icon,
        { Modifier ->
            Text("Calls Screen", modifier = Modifier)
        }
    )

    object Contacts : BottomNavigationScreens(
        "Contacts",
        R.drawable.contacts_icon,
        { Modifier ->
            Text("Contact Screen", modifier = Modifier)
        }
    )

    object Setting : BottomNavigationScreens(
        "Settings",
        R.drawable.setting_icon,
        { Modifier ->
            Text("Settings Screen", modifier = Modifier)
        }
    )
}