package com.codeclinic.codeassignment.data.repository.mainPageDataSource

import com.codeclinic.codeassignment.core.Resource
import com.codeclinic.codeassignment.data.model.DataListModel
import com.codeclinic.codeassignment.data.repository.mainPageDataSource.dataSource.MainPageRemoteDataSource
import com.codeclinic.codeassignment.domain.mainPage.MainPageRepository
import retrofit2.Response

/*Implementing repository implementation here with clean Architecture as API call are made in data source Class so keeping functionality separately making it easy to look and navigate through files
* Sealed class like Resource Class are used as Class Enums so that it can easily deduce what data are we getting and can manage errors easily */

class MainPageRepositoryImpl(
    private val remoteData: MainPageRemoteDataSource
) : MainPageRepository {

    override suspend fun getMainPageData(): Resource<List<DataListModel>> {
        val response = remoteData.callDashBoardAPI()
        return getResponseToResource(response)
    }

    private fun getResponseToResource(response: Response<List<DataListModel>>): Resource<List<DataListModel>> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }

        return Resource.Error(response.message())

    }

}