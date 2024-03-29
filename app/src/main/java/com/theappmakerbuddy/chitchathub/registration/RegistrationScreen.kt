package com.theappmakerbuddy.chitchathub.registration

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.theappmakerbuddy.chitchathub.MainActivity
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.common.AnimatedPreloader
import com.theappmakerbuddy.chitchathub.common.Constant
import com.theappmakerbuddy.chitchathub.common.PreferencesManager
import com.theappmakerbuddy.chitchathub.common.SharedPreferenceKey
import com.theappmakerbuddy.chitchathub.common.SocialMedia
import com.theappmakerbuddy.chitchathub.ui.theme.secondaryDark
import androidx.hilt.navigation.compose.hiltViewModel
import com.theappmakerbuddy.chitchathub.model.UserRequest
import com.theappmakerbuddy.chitchathub.utils.Results
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(
    navHostController: NavHostController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AnimatedPreloader(modifier = Modifier.size(325.dp), animation = R.raw.signup_anim)
        Text(
            text = "Welcome to our Chat App! Let's get started by creating an account.",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        Form(navHostController)
        Spacer(modifier = Modifier.size(15.dp))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Form(
    navHostController: NavHostController,
    viewModel: RegistrationViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current

    val focusManager = LocalFocusManager.current


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Email TextField
        TextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Username", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth()
                .bringIntoViewRequester(bringIntoViewRequester)
                .onFocusEvent { focusState ->
                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            trailingIcon = {
                Icon(Icons.Default.Person, contentDescription = null, tint = Color.White)
            },
            shape = RoundedCornerShape(percent = 12),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = secondaryDark.copy(alpha = 0.8f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                textColor = Color.White
            )
        )
        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth()
                .bringIntoViewRequester(bringIntoViewRequester)
                .onFocusEvent { focusState ->
                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                },
            trailingIcon = {
                Icon(Icons.Default.Email, contentDescription = null, tint = Color.White)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            shape = RoundedCornerShape(percent = 12),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = secondaryDark.copy(alpha = 0.8f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                textColor = Color.White
            )
        )
        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth()
                .bringIntoViewRequester(bringIntoViewRequester)
                .onFocusEvent { focusState ->
                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                },
            trailingIcon = {
                Icon(Icons.Default.Phone, contentDescription = null, tint = Color.White)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            shape = RoundedCornerShape(percent = 12),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = secondaryDark.copy(alpha = 0.8f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                textColor = Color.White
            )
        )
        Spacer(modifier = Modifier.size(8.dp))
        // Password TextField
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth()
                .bringIntoViewRequester(bringIntoViewRequester)
                .onFocusEvent { focusState ->
                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                },
            trailingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null, tint = Color.White)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(percent = 12),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = secondaryDark.copy(alpha = 0.8f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                textColor = Color.White
            )
        )

        Spacer(modifier = Modifier.size(8.dp))
        // Password TextField
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Confirm Password", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth()
                .bringIntoViewRequester(bringIntoViewRequester)
                .onFocusEvent { focusState ->
                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                },
            trailingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null, tint = Color.White)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = null
            ),
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(percent = 12),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = secondaryDark.copy(alpha = 0.8f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                textColor = Color.White
            )
        )

        Spacer(modifier = Modifier.size(15.dp))
        Button(
            onClick = {
                val user = UserRequest(
                    username = userName,
                    email = email,
                    phone = phone,
                    password = password,
                    userProfilePhoto = null
                )
                viewModel.register(userRequest = user)

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text("Signup", color = Color.Black, modifier = Modifier.padding(5.dp))
        }
        SocialMedia(viewModel)
        ClickableText(
            text = AnnotatedString("Existing account? Login"),
            modifier = Modifier
                .padding(top = 12.dp)
                .clickable {
                    navHostController.navigate(Constant.LOGIN)
                },
            onClick = { offset ->
                if (offset in 20..26) {
                    navHostController.navigate(Constant.LOGIN)
                }
            },
            style = LocalTextStyle.current.copy(color = Color.White, fontWeight = FontWeight.Medium)
        )
    }

    LaunchedEffect(viewModel.userResponse) {
        viewModel.userResponse.collect { userData ->
            when (userData) {
                is Results.Loading -> {
                    // Show loading indicator
//                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }

                is Results.Success -> {
                    PreferencesManager(context).setPreferenceValue(
                        SharedPreferenceKey.IS_LOGIN,
                        true
                    )
                    context.startActivity(Intent(context, MainActivity::class.java))
                }

                is Results.Error -> {
                    Log.e("ERROR", userData.toString())
                    Toast.makeText(context, userData.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}