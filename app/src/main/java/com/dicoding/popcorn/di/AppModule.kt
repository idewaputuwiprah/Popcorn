package com.dicoding.popcorn.di

import com.dicoding.popcorn.core.domain.usecase.PopcornInteractor
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun providePopcornUseCase(popcornInteractor: PopcornInteractor): PopcornUseCase
}