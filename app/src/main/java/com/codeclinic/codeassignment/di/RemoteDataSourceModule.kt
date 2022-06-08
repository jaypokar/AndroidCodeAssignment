package com.codeclinic.codeassignment.di

import com.codeclinic.codeassignment.data.api.APIService
import com.codeclinic.codeassignment.data.repository.mainPageDataSource.dataSource.MainPageRemoteDataSource
import com.codeclinic.codeassignment.data.repository.mainPageDataSource.dataSourceImpl.MainPageRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideMainPageDataSource(apiService: APIService): MainPageRemoteDataSource {
        return MainPageRemoteDataSourceImpl(apiService)
    }


}