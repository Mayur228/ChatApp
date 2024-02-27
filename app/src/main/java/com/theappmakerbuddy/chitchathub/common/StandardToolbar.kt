package com.theappmakerbuddy.chitchathub.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.ui.theme.ChatAppTheme
import com.theappmakerbuddy.chitchathub.ui.theme.primaryDark

@Composable
fun StandardToolbar(
    modifier: Modifier = Modifier,
    showBackArrow: Boolean = false,
    onBackArrowClicked: () -> Unit = {},
    navActions: @Composable RowScope.() -> Unit = {},
    title: @Composable () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = title,
        navigationIcon = if (showBackArrow) {
            {
                IconButton(
                    onClick =
                    onBackArrowClicked
                ) {
                    Image(
                        modifier = Modifier.size(27.dp),
                        painter = painterResource(id = R.drawable.back_icon),
                        contentDescription = null,
                    )
                }
            }
        } else null,
        actions = navActions,
        backgroundColor = primaryDark,
        elevation = 5.dp
    )
}

@Preview
@Composable
fun StandardToolbarPreview() {
    ChatAppTheme {
        StandardToolbar(
            title = {
                Text(
                    text = "About",
                    color = Color.White
                )
            }
        )
    }
}
