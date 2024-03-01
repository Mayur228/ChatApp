package com.theappmakerbuddy.chitchathub.network

import com.google.gson.GsonBuilder
import com.theappmakerbuddy.chitchathub.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun retrofitService(): UserApiService {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(UserApiService::class.java)
    }
}