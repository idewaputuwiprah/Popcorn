package com.dicoding.popcorn.di

import com.idputuwiprah.core.domain.usecase.PopcornInteractor
import com.idputuwiprah.core.domain.usecase.PopcornUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun providePopcornUseCase(popcornInteractor: PopcornInteractor): PopcornUseCase
}