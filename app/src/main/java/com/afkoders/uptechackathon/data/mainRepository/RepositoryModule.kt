package com.afkoders.uptechackathon.data.mainRepository

import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun provideRepository(apiRepository: MainRepositoryImpl): MainRepository
}