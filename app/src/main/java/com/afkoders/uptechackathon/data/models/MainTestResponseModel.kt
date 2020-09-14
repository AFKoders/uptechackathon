package com.afkoders.uptechackathon.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Kalevych Oleksandr on 9/14/20.
 */

data class MainTestResponseModel(
    @SerializedName("data")
    val data: List<EmployeeModel>,
    @SerializedName("status")
    val status: String
)

data class EmployeeModel(
    @SerializedName("employee_age")
    val employeeAge: String,
    @SerializedName("employee_name")
    val employeeName: String,
    @SerializedName("employee_salary")
    val employeeSalary: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("profile_image")
    val profileImage: String
)