package com.brian.kaizn.data.di

import android.app.Application
import androidx.room.Room
import com.brian.kaizn.data.local.dao.KaiznDao
import com.brian.kaizn.data.local.model.database.KaiznRoomDatabase
import com.brian.kaizn.data.repository.KaiznRepository
import com.brian.kaizn.data.repository.KaiznRepositoryImplementation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object KaiznDiModule {
    @Provides
    fun provideKaiznDatabase(application: Application): KaiznRoomDatabase {
        return Room.databaseBuilder(
            application,
            KaiznRoomDatabase::class.java,
            "database-name"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideKaiznDao(database: KaiznRoomDatabase): KaiznDao {
        return database.KaiznDao()
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideKaiznRepository(
        kaizndao: KaiznDao,
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore
    ): KaiznRepository =
        KaiznRepositoryImplementation(kaizndao, firebaseAuth, firebaseFirestore)
}