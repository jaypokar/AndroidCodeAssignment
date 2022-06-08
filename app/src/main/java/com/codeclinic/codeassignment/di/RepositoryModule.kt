package com.codeclinic.codeassignment.di

import com.codeclinic.codeassignment.data.repository.mainPageDataSource.MainPageRepositoryImpl
import com.codeclinic.codeassignment.data.repository.mainPageDataSource.dataSource.MainPageRemoteDataSource
import com.codeclinic.codeassignment.domain.mainPage.MainPageRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(dataSource: MainPageRemoteDataSource): MainPageRepository {
        return MainPageRepositoryImpl(dataSource)
    }

}