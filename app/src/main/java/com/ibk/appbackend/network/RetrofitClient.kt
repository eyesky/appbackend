package com.ibk.appbackend.network

import com.google.gson.GsonBuilder
import com.ibk.appbackend.BuildConfig
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofit: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    val client: Retrofit
        get() {
            if (retrofit == null) {
                synchronized(Retrofit::class.java) {
                    if (retrofit == null) {

                        val httpClient = OkHttpClient.Builder().addInterceptor(QueryParameterAddInterceptor())

                        // for pretty log of HTTP request-response
                        httpClient.addInterceptor(
                            LoggingInterceptor.Builder()
                                .setLevel(Level.BASIC)
                                .log(Platform.INFO)
                                .request("LOG")
                                .response("LOG")
//                                .addHeader("cityCode", "53")
//                                .addQueryParam("moonStatus", "crescent")
                                .build()
                        )

                        val client = httpClient.build()

                        retrofit = Retrofit.Builder()
                            .baseUrl(BuildConfig.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(client)
                            .build()
                    }
                }

            }
            return retrofit!!
        }
}