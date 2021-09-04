package com.idputuwiprah.favorite

import android.content.Context
import com.dicoding.popcorn.di.FavoriteModuleDependencies
import com.idputuwiprah.favorite.movieFav.MovieFavFragment
import com.idputuwiprah.favorite.tvFav.TVShowFavFragment
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {
    fun inject(activity: FavoriteActivity)
    fun inject(fragment: MovieFavFragment)
    fun inject(fragment: TVShowFavFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }
}