package com.theappmakerbuddy.chitchathub.setting

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.common.AnimatedPreloader
import com.theappmakerbuddy.chitchathub.common.Constant.LOGIN
import com.theappmakerbuddy.chitchathub.common.PreferencesManager
import com.theappmakerbuddy.chitchathub.common.SharedPreferenceKey
import com.theappmakerbuddy.chitchathub.common.StandardToolbar
import com.theappmakerbuddy.chitchathub.setting.component.SettingItem
import com.theappmakerbuddy.chitchathub.ui.theme.quicksand
import kotlinx.coroutines.delay

@Composable
fun SettingScreen(navController: NavHostController) {
    val context = LocalContext.current

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
            AnimatedPreloader(animation = R.raw.setting_anim)
        }
    }

    if (!isLoading) {
        Setting(navController)
    }

}

@Composable
fun Setting(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            StandardToolbar(
                onBackArrowClicked = {
//                    onEvent(HomeUiEvents.NavigateBack)
                },
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Setting",
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
                navActions = {
                    IconButton(onClick = {
                        navController.navigate(LOGIN)
                        PreferencesManager(context).setPreferenceValue(
                            SharedPreferenceKey.IS_LOGIN,
                            false
                        )
                    }) {
                        Image(
                            modifier = Modifier.size(27.dp),
                            painter = painterResource(id = R.drawable.ic_logout),
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
        ) {

            item {
                SettingItem("Account", R.drawable.ic_placeholder)
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }

            item {
                SettingItem("Lets CatchUp", R.drawable.ic_placeholder)
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }
            item {
                SettingItem("Notifications", R.drawable.ic_placeholder)
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }

            item {
                SettingItem("Share", R.drawable.ic_placeholder)
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }

            item {
                SettingItem("About", R.drawable.ic_placeholder)
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }
        }
    }
}