package com.codeclinic.codeassignment.domain.mainPage

import com.codeclinic.codeassignment.core.Resource
import com.codeclinic.codeassignment.data.model.DataListModel

interface MainPageRepository {
    suspend fun getMainPageData(): Resource<List<DataListModel>>

}