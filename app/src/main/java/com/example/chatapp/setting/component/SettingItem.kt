package com.example.chatapp.setting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.R

@Composable
fun SettingItem(title: String, icon: Int) {
    Row(
        verticalAlignment =  Alignment.CenterVertically
    ) {
/*
        Image(
            modifier = Modifier
                .size(50.dp)
                .padding(start = 12.dp,end = 10.dp),
            painter = painterResource(id = R.drawable.ic_placeholder),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White)
        )
*/

        Text(
            modifier = Modifier
                .padding(vertical = 16.dp,horizontal = 16.dp),
            text = title,
            color = Color.White,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun SettingPreview()
{
    SettingItem("Profile", R.drawable.ic_placeholder)
}