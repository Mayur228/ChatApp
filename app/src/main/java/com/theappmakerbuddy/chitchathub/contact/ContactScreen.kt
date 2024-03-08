package com.theappmakerbuddy.chitchathub.contact

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.common.AnimatedPreloader
import com.theappmakerbuddy.chitchathub.common.StandardToolbar
import com.theappmakerbuddy.chitchathub.common.model.User
import com.theappmakerbuddy.chitchathub.contact.component.ContactItem
import com.theappmakerbuddy.chitchathub.ui.theme.quicksand
import com.theappmakerbuddy.chitchathub.utils.Results
import com.theappmakerbuddy.chitchathub.utils.getContactList
import kotlinx.coroutines.delay

@Composable
fun ContactScreen() {

    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        // Simulate some background work or delay
        // You can replace this with your actual initialization or loading logic
        delay(2000)
        isLoading = false
    }

    AnimatedVisibility(visible = isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            AnimatedPreloader(animation = R.raw.contact_anim)
        }
    }

    if (!isLoading) {
        Contact()
    }

}

@Composable
fun Contact(viewModel: ContactViewModel = hiltViewModel()) {
    val contactListState = getContactList()
    val context = LocalContext.current
    var filteredContactList by remember { mutableStateOf(emptySet<User>()) }

    Scaffold(
        topBar = {
            StandardToolbar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Contacts",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = quicksand,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                showBackArrow = false,
            )
        }
    ) { innerPadding ->

        LaunchedEffect(viewModel.userResponse) {
            viewModel.userResponse.collect { userData ->
                when (userData) {
                    is Results.Loading -> {
                        // Show loading indicator
                        // CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                    }

                    is Results.Success -> {
                        val userList = userData.data

                        // Filter the contactListState based on user phone numbers

                         filteredContactList = contactListState.value.flatMap { contact ->
                             val matchingUsers = userList?.filter { user ->
                                 user.phone == contact.phoneNumber
                             } ?: emptyList()
                             matchingUsers
                         }.toSet()

                    }

                    is Results.Error -> {
                        Log.e("ERROR", userData.toString())
                        Toast.makeText(context, userData.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        UserList(
            modifier = Modifier.padding(innerPadding),
            contactList = filteredContactList.toList()
        )
    }
}

@Composable
fun UserList(modifier: Modifier, contactList: List<User>?) {
    LazyColumn(
        modifier = modifier
    ) {
        contactList?.forEach {
            item {
                ContactItem(it)
            }
        }
    }
}