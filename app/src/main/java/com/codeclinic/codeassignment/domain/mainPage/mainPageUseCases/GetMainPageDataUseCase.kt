package com.codeclinic.codeassignment.domain.mainPage.mainPageUseCases

import com.codeclinic.codeassignment.core.Resource
import com.codeclinic.codeassignment.data.model.DataListModel
import com.codeclinic.codeassignment.domain.mainPage.MainPageRepository


class GetMainPageDataUseCase(private val repository: MainPageRepository) {
    suspend operator fun invoke(): Resource<List<DataListModel>> = repository.getMainPageData()
}