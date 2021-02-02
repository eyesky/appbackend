package com.ibk.appbackend.features.model

import com.ibk.appbackend.common.RequestCompleteListener
import com.ibk.appbackend.features.model.data_class.EmployeeInfoResponse
import com.ibk.appbackend.network.ApiInterface
import com.ibk.appbackend.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeInfoShowModelImpl : EmployeeInfoShowModel {

    override fun getEmployeeInfo(callback: RequestCompleteListener<EmployeeInfoResponse>) {
        val apiInterface: ApiInterface = RetrofitClient.client.create(ApiInterface::class.java)
        val call: Call<EmployeeInfoResponse> = apiInterface.callApiForWeatherInfo()

        call.enqueue(object : Callback<EmployeeInfoResponse> {
            // if retrofit network call success, this method will be triggered
            override fun onResponse(call: Call<EmployeeInfoResponse>, response: Response<EmployeeInfoResponse>) {
                if (response.body() != null)
                    callback.onRequestSuccess(response.body()!!) //let presenter know the weather information data
                else
                    callback.onRequestFailed(response.message()) //let presenter know about failure
            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<EmployeeInfoResponse>, t: Throwable) {
                callback.onRequestFailed(t.localizedMessage!!) //let presenter know about failure
            }

        })
    }
}