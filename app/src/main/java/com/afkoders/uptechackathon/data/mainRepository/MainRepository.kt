package com.afkoders.uptechackathon.data.mainRepository

import com.afkoders.uptechackathon.data.models.EmployeeModel
import io.reactivex.Single

interface MainRepository {

    fun getTestData(): Single<List<String>>
    fun getTestDataFromNetwork(): Single<List<EmployeeModel>>
    fun getTestDataFromDataStorage(): Single<List<EmployeeModel>>
}