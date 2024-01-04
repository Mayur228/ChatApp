package com.example.chatapp.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.R
import com.example.chatapp.ui.theme.ChatAppTheme


@Composable
fun SocialMedia() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularImage(R.drawable.google_icon)
        Box(modifier = Modifier.size(10.dp))
        CircularImage(R.drawable.phone_icon)
    }
}

@Composable
fun CircularImage(image: Int) {
    Card(
        modifier = Modifier
            .size(50.dp)
            .border(2.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary,
                    ),
                ),
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(25.dp)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatAppTheme {
        SocialMedia()
    }
}