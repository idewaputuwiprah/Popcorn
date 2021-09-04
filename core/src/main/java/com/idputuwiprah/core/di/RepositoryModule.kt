package com.idputuwiprah.core.di

import com.idputuwiprah.core.data.PopcornRepository
import com.idputuwiprah.core.domain.repository.IPopcornRepository
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