package com.ibk.appbackend.network

import com.ibk.appbackend.features.model.data_class.EmployeeInfoResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/root/get/all")
    fun callApiForWeatherInfo(): Call<EmployeeInfoResponse>
}