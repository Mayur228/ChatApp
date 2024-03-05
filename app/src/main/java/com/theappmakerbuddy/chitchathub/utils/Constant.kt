package com.theappmakerbuddy.chitchathub.utils

object Constant {
    private const val BASE_URL = "http://0.0.0.0:8080/"
    const val REGISTER_USER_API = "${BASE_URL}/user/register"
    const val LOGIN_WITH_EMAIL = "${BASE_URL}/user/byEmail"
    const val LOGIN_WITH_PHONE = "${BASE_URL}/user/byPhone"
    const val LOGIN_WITH_USERNAME = "${BASE_URL}/user/byUsername"
    const val GET_USER = "${BASE_URL}/user/byId"
    const val UPDATE_USER_DETAILS = "${BASE_URL}/user/profile"
    const val UPDATE_USER_PROFILE = "${BASE_URL}/user/profile/photo"
    const val CHANGE_PASSWORD = "${BASE_URL}/user/changePassword"
    const val DELETE_USER = "${BASE_URL}/user/delete"
}