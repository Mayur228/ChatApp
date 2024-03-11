package com.theappmakerbuddy.chitchathub.utils

import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ComponentActivity.CheckAndRequestPermission(
    vararg permissions: String,
    onPermissionGranted: () -> Unit,
    onPermissionDenied: () -> Unit
) {
    val multiplePermissionsState = rememberMultiplePermissionsState(permissions.toList())

    if (multiplePermissionsState.allPermissionsGranted) {
        onPermissionGranted()
    } else {
        val launcher = rememberPermissionLauncher(this) { result ->
            if (result) {
                onPermissionGranted()
            } else {
                onPermissionDenied()
            }
        }

        if (multiplePermissionsState.shouldShowRationale) {
            // Show rationale or explanation to the user if needed
        }

        launcher.launch(permissions)
    }
}

@Composable
private fun rememberPermissionLauncher(
    activity: ComponentActivity,
    onResult: (Boolean) -> Unit
): MultiplePermissionsRequestLauncher {
    return remember(activity) {
        MultiplePermissionsRequestLauncher(
            activity = activity,
            onResult = onResult
        )
    }
}

class MultiplePermissionsRequestLauncher(
    private val activity: ComponentActivity,
    private val onResult: (Boolean) -> Unit
) {
    private val launcher =
        activity.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            onResult(permissions.values.all { it })
        }

    fun launch(permissions: Array<out String>) {
        launcher.launch(permissions as? Array<String>?)
    }
}
