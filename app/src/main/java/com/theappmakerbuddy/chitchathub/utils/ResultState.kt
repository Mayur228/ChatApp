package com.theappmakerbuddy.chitchathub.utils

sealed class Results<out R> {
    data object Loading : Results<Nothing>()
    data class Success<out R>(val data: R? = null) : Results<R>()
    data class Error(val exception: String) : Results<Nothing>()
}