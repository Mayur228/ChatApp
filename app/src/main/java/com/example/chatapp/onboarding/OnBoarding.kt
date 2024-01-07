package com.example.chatapp.onboarding

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.common.SocialMedia

@Composable
fun OnBoarding() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontSize = 68.sp,
                    ),
                ) {
                    append("Connect\n\n\n")
                    append("friends\n\n\n")

                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 68.sp,
                    ),
                ) {
                    append("easily &\n\n\n")
                    append("quickly")

                }
            },
            textAlign = TextAlign.Start,
            modifier = Modifier.align(Alignment.Start)
        )
        Box(modifier = Modifier.size(10.dp))
        Text(
            text = "Our chat app is the perfect way to stay connected with friends and family.",
            color = Color.White
        )
        Box(modifier = Modifier.size(30.dp))
        SocialMedia()
        Button(
            onClick = {
                // Handle button click
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Sign up with mail")
        }

        Box(modifier = Modifier.size(10.dp))

        ClickableText(
            text = AnnotatedString("Existing account? Login"),
            modifier = Modifier
                .clickable {
                // Handle click action, e.g., navigate to login screen
            },
            onClick = { offset ->
                // Handle specific click actions if needed
                if (offset in 20..25) {
                    // "Login" clicked
                }
            },
            style = LocalTextStyle.current.copy(color = Color.White)
        )
    }
}