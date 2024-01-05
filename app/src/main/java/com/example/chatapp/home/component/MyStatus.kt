package com.example.chatapp.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
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
import com.example.chatapp.R

@Composable
fun MyStatusContent() {
    Box(

    ) {
        Text(
            text = "My Status",
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
                .offset(x = 4.dp, y = 0.dp)
                .requiredSize(size = 58.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_icon),
                contentDescription = "Ellipse 308",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 3.dp, y = 3.dp)
                    .requiredSize(size = 52.dp)
                    .clip(shape = CircleShape)
            )

            Box(
                modifier = Modifier
                    .requiredSize(size = 58.dp)
                    .clip(shape = CircleShape)
                    .border(
                        border = BorderStroke(1.2.dp, Color.White),
                        shape = CircleShape
                    )
            )

            Box(
                modifier = Modifier
                    .requiredSize(size = 58.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredSize(size = 58.dp)
                        .clip(shape = CircleShape)
                        .border(
                            border = BorderStroke(1.2.dp, Color(0xff363f3b)),
                            shape = CircleShape
                        )
                )
                Box(
                    modifier = Modifier
                        .requiredSize(size = 58.dp)
                        .clip(shape = CircleShape)
                        .border(
                            border = BorderStroke(1.2.dp, Color(0xff363f3b)),
                            shape = CircleShape
                        )
                )
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

            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 42.dp, y = 42.dp)
                    .requiredSize(size = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredSize(size = 16.dp)
                        .clip(shape = CircleShape)
                        .background(color = Color.White)
                        .border(
                            border = BorderStroke(1.dp, Color(0xff111314)),
                            shape = CircleShape
                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "plus",
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 3.dp, y = 3.dp)
                        .requiredSize(size = 10.dp)
                )
            }
        }
    }
}