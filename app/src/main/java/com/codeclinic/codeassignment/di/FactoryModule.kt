package com.codeclinic.codeassignment.di

import android.app.Application
import com.codeclinic.codeassignment.domain.mainPage.mainPageUseCases.GetMainPageDataUseCase
import com.codeclinic.codeassignment.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FactoryModule {
    @Singleton
    @Provides
    fun provideMainVMFactory(
        app: Application,
        getMainDataUseCase: GetMainPageDataUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(app, getMainDataUseCase)
    }


}