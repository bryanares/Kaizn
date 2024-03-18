package com.brian.kaizn.data.di

import android.app.Application
import androidx.room.Room
import com.brian.kaizn.data.local.dao.KaiznDao
import com.brian.kaizn.data.local.model.database.KaiznRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object KaiznDiModule {
    @Provides
    fun provideKaiznDatabase(application: Application) : KaiznRoomDatabase{
        return Room.databaseBuilder(
            application,
            KaiznRoomDatabase::class.java,
            "database-name"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideKaiznDao(database: KaiznRoomDatabase) : KaiznDao{
        return database.KaiznDao()
    }
}