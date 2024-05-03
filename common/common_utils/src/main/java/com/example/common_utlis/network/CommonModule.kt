package com.example.common_utlis.network

import android.content.Context
import com.example.common_utlis.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object CommonModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        //       okHttpClient.addInterceptor(AuthInterceptor(context))
        okHttpClient.addInterceptor(NetworkInterceptor(context))
        //     okHttpClient.addInterceptor(AuthApiKeyInterceptor(context))
        okHttpClient.hostnameVerifier { hostname, session -> true }
        okHttpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        okHttpClient.readTimeout(60, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS)
        return okHttpClient.build()
    }

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()



}