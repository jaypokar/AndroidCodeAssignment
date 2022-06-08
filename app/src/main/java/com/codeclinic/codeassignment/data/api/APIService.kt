package com.codeclinic.codeassignment.data.api

import com.codeclinic.codeassignment.data.model.DataListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface APIService {

    //Fetch Main Page Data
    @Headers("Content-Type: application/json")
    @GET("photos")
    suspend fun fetchMainPageDataAPI(@Query("client_id") clientSecret: String): Response<List<DataListModel>>
}