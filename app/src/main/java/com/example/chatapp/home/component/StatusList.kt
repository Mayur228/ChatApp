package com.example.chatapp.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chatapp.R


@Composable
fun StatusList(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // My Status
        item {
            MyStatusContent()
        }
        // Other statuses
        item {
            OtherStatusContent(
                name = "user name",
                imageResource = R.drawable.google_icon,
                backgroundColor = Color(0xffeda0a8)
            )
        }

        item {
            OtherStatusContent(
                name = "user name",
                imageResource = R.drawable.google_icon,
                backgroundColor = Color(0xffeda0a8)
            )
        }
        item {
            OtherStatusContent(
                name = "user name",
                imageResource = R.drawable.google_icon,
                backgroundColor = Color(0xffeda0a8)
            )
        }

    }
}