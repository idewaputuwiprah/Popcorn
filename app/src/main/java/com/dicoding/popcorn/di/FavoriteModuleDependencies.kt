package com.dicoding.popcorn.di

import com.idputuwiprah.core.domain.usecase.PopcornUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun popcornUseCase(): PopcornUseCase
}