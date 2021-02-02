package com.ibk.appbackend.features.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibk.appbackend.common.RequestCompleteListener
import com.ibk.appbackend.features.model.EmployeeInfoShowModel
import com.ibk.appbackend.features.model.data_class.EmployeeInfoResponse

class EmployeeInfoViewModel : ViewModel() {

    private val progressBarLiveData = MutableLiveData<Boolean>()
    val employeeInfoLiveData = MutableLiveData<EmployeeInfoResponse>()
    val employeeInfoFailureLiveData = MutableLiveData<String>()

    fun getWeatherInfo(model: EmployeeInfoShowModel) {

        progressBarLiveData.postValue(true) // PUSH data to LiveData object to show progress bar

        model.getEmployeeInfo(object : RequestCompleteListener<EmployeeInfoResponse> {
            override fun onRequestSuccess(data: EmployeeInfoResponse) {
                var employeeResponse = EmployeeInfoResponse(

                    createdAt = data.createdAt,
                    updatedAt = data.updatedAt,
                    totalRow = data.totalRow,
                    employeeNumber = data.employeeNumber,
                    firstName = data.firstName,
                    lastName = data.lastName,
                    extension = data.extension,
                    email = data.email,
                    officeCode = data.officeCode,
                    reportsTo = data.reportsTo,
                    jobTitle = data.jobTitle
                )
                progressBarLiveData.postValue(false) // PUSH data to LiveData object to hide progress bar

                // After applying business logic and data manipulation, we push data to show on UI
                employeeInfoLiveData.postValue(employeeResponse) // PUSH data to LiveData object
            }

            override fun onRequestFailed(errorMessage: String) {
                progressBarLiveData.postValue(false) // hide progress bar
                employeeInfoFailureLiveData.postValue(errorMessage) // PUSH error message to LiveData object
            }

        })

    }
}