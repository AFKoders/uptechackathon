package com.afkoders.uptechackathon.data.mainRepository

import io.reactivex.Single

interface MainRepository {

    fun getTestData(): Single<List<String>>
    fun getTestDataFromNetwork(): Single<List<String>>
    fun getTestDataFromDataStorage(): Single<List<String>>
}