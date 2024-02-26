package com.example.chatapp.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatapp.R
import com.example.chatapp.common.AnimatedPreloader
import com.example.chatapp.common.Constant.LOGIN

@Composable
fun OnBoarding(
    navHostController: NavHostController
) {

    Box {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
        ) {

            Spacer(modifier = Modifier.size(50.dp))

            Text(
                text = "Welcome to ChitChat Hub",
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )

            AnimatedPreloader(
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally),
                animation = R.raw.on_borading2,
            )

            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Light,
                            fontSize = 40.sp,
                        ),
                    ) {
                        append("Connect your  ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 40.sp,
                        ),
                    ) {
                        append("\nfriends & family")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 42.sp,
                        ),
                    ) {
                        append("\neasily & quickly")

                    }
                },
                textAlign = TextAlign.Start,
            )
            Box(modifier = Modifier.size(20.dp))
            Text(
                text = "Our chat app is the perfect way to stay connected with friends and family.",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

        }

        Box(modifier = Modifier.size(15.dp))

        Button(
            onClick = {
                // Handle button click
                navHostController.navigate(LOGIN)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
                .align(Alignment.BottomCenter)
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Start your Journey")
        }
    }
}