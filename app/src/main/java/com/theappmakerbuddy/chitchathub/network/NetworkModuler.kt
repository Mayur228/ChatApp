package com.theappmakerbuddy.chitchathub.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun provideHttpClient(): UserApiService {
        return UserApiServiceImpl(
            httpClient = HttpClient(CIO) {
                install(Logging){
                    level = LogLevel.ALL
                }
            }
        )
    }
}