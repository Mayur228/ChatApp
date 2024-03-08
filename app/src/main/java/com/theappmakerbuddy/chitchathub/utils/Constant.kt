package com.theappmakerbuddy.chitchathub.utils

object Constant {
    private const val BASE_URL = "http://192.168.29.236:8080"
    private const val WEB_SOCKET = "ws://192.168.29.236:8080"

    //USER API
    const val REGISTER_USER_API = "${BASE_URL}/user/register"
    const val LOGIN_WITH_EMAIL = "${BASE_URL}/user/byEmail"
    const val LOGIN_WITH_PHONE = "${BASE_URL}/user/byPhone"
    const val LOGIN_WITH_USERNAME = "${BASE_URL}/user/byUsername"
    const val GET_USER = "${BASE_URL}/user/byId"
    const val GET_ALL_USER = "${BASE_URL}/user"
    const val UPDATE_USER_DETAILS = "${BASE_URL}/user/profile"
    const val UPDATE_USER_PROFILE = "${BASE_URL}/user/profile/photo"
    const val CHANGE_PASSWORD = "${BASE_URL}/user/changePassword"
    const val DELETE_USER = "${BASE_URL}/user/delete"

    //CHAT API
    const val CHAT = "${WEB_SOCKET}/ws/chat"
}