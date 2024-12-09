package com.rizki.crud_data_mysql_mi2b.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    //https://dummyjson.com/docs/products
    private const val BASE_URL = "http://10.152.34.149:8080/beritaDb/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(interceptor()) // tambah
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //add interceptor
    fun interceptor(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    val beritaServices : CrudService by lazy {
        retrofit.create(CrudService::class.java)
    }
}