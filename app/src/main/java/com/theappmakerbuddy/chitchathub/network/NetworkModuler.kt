package com.theappmakerbuddy.chitchathub.network

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.Charsets
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): UserApiService {
        return UserApiServiceImpl(
            httpClient = HttpClient(CIO) {

                Charsets {
                    // Allow using `UTF_8`.
                    register(Charsets.UTF_8)
//
//                    // Allow using `ISO_8859_1` with quality 0.1.
//                    register(Charsets.ISO_8859_1, quality=0.1f)
                }

                install(Logging) {
                    level = LogLevel.ALL
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.e("TAG",message)
                        }
                    }
                }

                install(ContentNegotiation) {
                    json(
                        json = Json {
                            prettyPrint = true
                            isLenient = true
                        },
                        contentType = ContentType.Application.Json
                    )
                    headers {
                        ContentType.Application.Json
                    }
                }

                defaultRequest {
                    contentType(ContentType.Application.Json)
                    accept(ContentType.Application.Json)
                    header(HttpHeaders.ContentType, ContentType.Application.Json)

                }

            }
        )
    }
}