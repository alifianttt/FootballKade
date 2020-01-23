package com.yoga.footballleague.restapi

import com.yoga.footballleague.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseRest {
    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun <T> createService(service: Class<T>): T {
        return buildRetrofit().create(service)
    }
}