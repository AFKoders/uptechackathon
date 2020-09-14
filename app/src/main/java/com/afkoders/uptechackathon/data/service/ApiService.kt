package com.afkoders.uptechackathon.data.service

import com.afkoders.uptechackathon.data.models.MainTestResponseModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v1/employees")
    fun getTestDataFromNetwork(
        //@Query("q", encoded = true) query: String
    ): Single<MainTestResponseModel>
}