package com.example.chatapp.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingScreen() {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .padding(15.dp),
    ) {

        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Account",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            )
            Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
        }

        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Lets CatchUp",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            )
            Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Notifications",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            )
            Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
        }

        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Share",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            )
            Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
        }

        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "About",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            )
            Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
        }
    }
}