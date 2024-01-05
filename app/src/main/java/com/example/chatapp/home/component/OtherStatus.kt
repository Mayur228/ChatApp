package com.example.chatapp.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun OtherStatusContent(name: String, imageResource: Int, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .requiredWidth(width = 58.dp)
            .requiredHeight(height = 82.dp)
    ) {
        Text(
            text = name,
            color = Color.White,
            textAlign = TextAlign.Center,
            lineHeight = 1.em,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp, y = 68.dp)
        )

        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .requiredSize(size = 58.dp)
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "Status Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 3.dp, y = 3.dp)
                    .requiredSize(size = 52.dp)
                    .clip(shape = CircleShape)
                    .background(color = backgroundColor)
            )

        }
        Box(
            modifier = Modifier
                .requiredSize(size = 58.dp)
                .clip(shape = CircleShape)
                .border(
                    border = BorderStroke(1.2.dp, Color(0xff363f3b)),
                    shape = CircleShape
                )
        )
    }
}