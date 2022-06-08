package com.codeclinic.codeassignment.di

import com.codeclinic.codeassignment.domain.mainPage.MainPageRepository
import com.codeclinic.codeassignment.domain.mainPage.mainPageUseCases.GetMainPageDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideLoginUseCase(repository: MainPageRepository): GetMainPageDataUseCase {
        return GetMainPageDataUseCase(repository)
    }
}