package com.theappmakerbuddy.chitchathub.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.common.AnimatedPreloader
import com.theappmakerbuddy.chitchathub.ui.theme.secondaryDark

@Composable
fun Otp(
//    navHostController: NavHostController,
    onSubmit: (String) -> Unit
) {

    val otpLength = 6 // Change as per your requirement
    val otpState = remember { mutableStateListOf<String>() }
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.size(50.dp))

        Text(
            text = "Please enter the OTP sent to your mobile number.",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )

        AnimatedPreloader(modifier = Modifier.size(250.dp), animation = R.raw.forgot_password)

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = "Enter OTP",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        )

        Spacer(modifier = Modifier.size(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in 0 until otpLength) {
                OtpDigit(
                    digit = otpState.getOrElse(i) { "" },
                    onDigitChange = { digit ->
                        otpState[i] = digit
                        if (digit.length == 1 && i < otpLength - 1) {
                            otpState.getOrNull(i + 1)?.let { nextDigit ->
                                if (nextDigit.isEmpty()) {
                                    // Focus next digit
                                    // You may want to handle this based on your UI navigation strategy
                                }
                            }
                        }
                    }
                )
            }
        }


        Spacer(modifier = Modifier.size(15.dp))

        Button(
            onClick = {
                val otp = otpState.joinToString("")

                onSubmit(otp)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }

    }
}
@Composable
fun OtpDigit(digit: String, onDigitChange: (String) -> Unit) {
    OutlinedTextField(
        value = digit,
        onValueChange = { onDigitChange(it.takeLast(1)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.width(60.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewOtpScreen() {
    Otp(onSubmit = {})
}