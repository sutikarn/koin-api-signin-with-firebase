package com.example.bubblepicker.Module

import android.content.Context
import com.example.bubblepicker.Api.LuckyApi
import com.example.bubblepicker.Api.OkHttpMockInterceptor
import com.example.bubblepicker.Room.AppDatabase
import com.example.bubblepicker.pref.PrefUtils
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

var mainModule = module {

    single { createWebService(get()) }

    single { okHttpClient(get()) }

    single{ PrefUtils.instance }

}

fun createWebService(context: Context): LuckyApi {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://www.romexchange.com/")
        .client(okHttpClient(context))
        .build()

    return retrofit.create(LuckyApi::class.java)
}
fun okHttpClient(context: Context) : OkHttpClient {

    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(OkHttpMockInterceptor(context))
    return httpClient.apply {
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(60, TimeUnit.SECONDS)
        writeTimeout(60, TimeUnit.SECONDS)
    }.build()
}