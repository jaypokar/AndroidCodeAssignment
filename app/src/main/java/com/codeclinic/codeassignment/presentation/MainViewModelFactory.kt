package com.codeclinic.codeassignment.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codeclinic.codeassignment.domain.mainPage.mainPageUseCases.GetMainPageDataUseCase

class MainViewModelFactory(
    private val app: Application,
    private val getMainPageDataUseCase: GetMainPageDataUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            app,
            getMainPageDataUseCase
        ) as T
    }
}