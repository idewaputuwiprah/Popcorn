package com.dicoding.popcorn.core.di

import com.dicoding.popcorn.core.data.PopcornRepository
import com.dicoding.popcorn.core.domain.repository.IPopcornRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(popcornRepository: PopcornRepository): IPopcornRepository
}