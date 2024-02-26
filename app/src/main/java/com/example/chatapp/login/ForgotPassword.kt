package com.example.chatapp.login

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatapp.MainActivity
import com.example.chatapp.R
import com.example.chatapp.common.AnimatedPreloader
import com.example.chatapp.common.Constant
import com.example.chatapp.common.PreferencesManager
import com.example.chatapp.common.SharedPreferenceKey
import com.example.chatapp.common.SocialMedia
import com.example.chatapp.ui.theme.secondaryDark

@Composable
fun ForgotPasswordPage(
    navHostController: NavHostController
) {

    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.size(50.dp))

        Text(
            text = "Forgot your password? No worries! Let's get you back on track.",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )

        AnimatedPreloader(modifier = Modifier.size(250.dp), animation = R.raw.forgot_password)

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = "Enter your new password below",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        )

        Spacer(modifier = Modifier.size(15.dp))

        PasswordForm(navHostController)

        Spacer(modifier = Modifier.size(15.dp))

    }
}

@Composable
fun PasswordForm(navHostController: NavHostController) {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        // Email TextField
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password",color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null,tint = Color.White)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            shape = RoundedCornerShape(percent = 12),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor =  secondaryDark.copy(alpha = 0.8f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                textColor = Color.White
            )
        )
        Spacer(modifier = Modifier.size(8.dp))
        // Password TextField
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password",color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null,tint = Color.White)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(percent = 12),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor =  secondaryDark.copy(alpha = 0.8f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                textColor = Color.White
            )
        )

        Spacer(modifier = Modifier.size(15.dp))

        // Button to simulate login action
        Button(
            onClick = {
//                PreferencesManager(context).setPreferenceValue(SharedPreferenceKey.IS_LOGIN,true)
//                context.startActivity(Intent(context, MainActivity::class.java))

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text("Change It", color = Color.Black, modifier = Modifier.padding(5.dp))
        }
    }
}