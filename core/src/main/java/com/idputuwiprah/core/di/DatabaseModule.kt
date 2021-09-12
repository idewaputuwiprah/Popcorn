package com.idputuwiprah.core.di

import android.content.Context
import androidx.room.Room
import com.idputuwiprah.core.data.local.room.PopcornDAO
import com.idputuwiprah.core.data.local.room.PopcornRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PopcornRoomDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("idputuwiprah".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            PopcornRoomDatabase::class.java,
            "popcorn_database"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun providePopcornDao(database: PopcornRoomDatabase): PopcornDAO = database.popcornDao()
}