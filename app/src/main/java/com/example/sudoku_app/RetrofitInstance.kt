package com.example.sudoku_app

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    val api: SudokuApi by lazy {
        Retrofit.Builder()
            .client(client)
            .baseUrl("http://192.168.0.24:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SudokuApi::class.java)
    }
}