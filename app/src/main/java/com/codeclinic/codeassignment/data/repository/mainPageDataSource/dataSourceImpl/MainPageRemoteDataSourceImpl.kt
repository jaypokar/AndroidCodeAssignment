package com.codeclinic.codeassignment.data.repository.mainPageDataSource.dataSourceImpl

import com.codeclinic.codeassignment.config.AppConfig
import com.codeclinic.codeassignment.data.api.APIService
import com.codeclinic.codeassignment.data.model.DataListModel
import com.codeclinic.codeassignment.data.repository.mainPageDataSource.dataSource.MainPageRemoteDataSource
import retrofit2.Response

//Implementing the Remote dataSource in this gives us easy access to debug and clears other factors getting in the way like other methods and UI logic which makes it more convoluted.
//hence separating business logic from client logic makes it easier for us to scale and test in future.

class MainPageRemoteDataSourceImpl(private val api: APIService) : MainPageRemoteDataSource {

    override suspend fun callDashBoardAPI(): Response<List<DataListModel>> {
        val clientAccessKey = AppConfig.CLIENT_ACCESS_KEY
        //Log.i("dataReq", "Client Access Key : $clientAccessKey")
        return api.fetchMainPageDataAPI(clientAccessKey)
    }
}