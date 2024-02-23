package com.example.chatapp.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimatedPreloader(modifier: Modifier = Modifier,animation: Int, loop: Boolean = true,) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            animation
        )
    )

    val iterations = if (loop) LottieConstants.IterateForever else 1

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = iterations,
        isPlaying = true
    )


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}