package com.ibk.appbackend.features.model

import com.ibk.appbackend.common.RequestCompleteListener
import com.ibk.appbackend.features.model.data_class.EmployeeInfoResponse

interface EmployeeInfoShowModel {
    fun getEmployeeInfo(callback: RequestCompleteListener<EmployeeInfoResponse>)
}