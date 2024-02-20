package com.example.chatapp.common.model


import com.example.chatapp.R


sealed class BottomNavItem(var title: String, var icon: Int,var destination: String) {
    data object Message : BottomNavItem(
        title = "Message",
        icon = R.drawable.chat_icon,
        destination = "message"
    )
    data object Calls: BottomNavItem(
        title = "Calls",
        icon = R.drawable.call_icon,
        destination = "calls"
    )
    data object Contacts: BottomNavItem(
        title = "Contacts",
        icon = R.drawable.contact_icon,
        destination = "contacts"
    )
    data object Settings: BottomNavItem(
        title = "Settings",
        icon = R.drawable.setting_icon,
        destination = "settings"
    )
}
