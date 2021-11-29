package com.app.changersdoggoapp.di

import com.app.changersdoggoapp.BuildConfig
import com.app.changersdoggoapp.data.api.TheDogApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkhttp(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
        )
        .addInterceptor { chain ->
            val request = chain.request()
            val newRequest = request.newBuilder()
                .addHeader("x-api-key", BuildConfig.DOG_API_KEY)
                .build()
            chain.proceed(newRequest)
        }
        .build()

    @Provides
    fun provideDogApi(retrofit: Retrofit): TheDogApi = retrofit.create(TheDogApi::class.java)

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().client(okHttpClient)
            .baseUrl(BuildConfig.DOG_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
}