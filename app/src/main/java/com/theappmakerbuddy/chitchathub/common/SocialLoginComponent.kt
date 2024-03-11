package com.theappmakerbuddy.chitchathub.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.registration.RegistrationViewModel


@Composable
fun SocialMedia(viewModel: RegistrationViewModel? = null) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.White)
                    .height(1.dp)
            )
            Text(
                text = "OR",
                modifier = Modifier
                    .padding(10.dp),
                color = Color.White
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.White)
                    .height(1.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            CircularImage(R.drawable.ic_google)
            /*Image(
                painter = painterResource(R.drawable.ic_google),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                       viewModel?.loginWithEmail()
                    }
            )
            Box(modifier = Modifier.size(8.dp))*/
            CircularImage(R.drawable.ic_phone_auth)
           /* Image(
                painter = painterResource(R.drawable.ic_facebook),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(45.dp)
            )*/
        }

    }

}

@Composable
fun CircularImage(image: Int) {
    Card(
        modifier = Modifier
            .size(50.dp)
            .border(1.dp, Color.Black, CircleShape),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(12.dp),
        elevation = 16.dp
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

@Preview
@Composable
fun SocialLoginComponentPreview() {
    SocialMedia()
}