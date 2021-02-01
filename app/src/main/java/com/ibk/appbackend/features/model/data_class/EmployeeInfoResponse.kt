package com.ibk.appbackend.features.model.data_class

import com.google.gson.annotations.SerializedName

data class EmployeeInfoResponse(
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("updatedAt")
    val updatedAt: String = "",
    @SerializedName("totalRow")
    val totalRow: String = "",
    @SerializedName("employeeNumber")
    val employeeNumber: Int = 0,
    @SerializedName("firstName")
    val firstName: String = "",
    @SerializedName("lastName")
    val lastName: String = "",
    @SerializedName("extension")
    val extension: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("officeCode")
    val officeCode: String = "",
    @SerializedName("reportsTo")
    val reportsTo: Int = 0,
    @SerializedName("jobTitle")
    val jobTitle: String = ""
)