package com.codeclinic.codeassignment.data.repository.mainPageDataSource.dataSource

import com.codeclinic.codeassignment.data.model.DataListModel
import retrofit2.Response

interface MainPageRemoteDataSource {
    suspend fun callDashBoardAPI(): Response<List<DataListModel>>
}