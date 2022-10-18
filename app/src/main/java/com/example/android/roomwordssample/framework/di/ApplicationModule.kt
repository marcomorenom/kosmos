package com.example.android.roomwordssample.framework.di

import android.app.Application
import com.example.android.roomwordssample.applicaiton.daos.WordDao
import com.example.android.roomwordssample.framework.persistance.WordRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {


    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts

    @Provides
    @Singleton
    fun provideApplicationScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob())
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWordRoomDatabase(applicationScope: CoroutineScope, application: Application): WordRoomDatabase {
        return  WordRoomDatabase.getDatabase(application.applicationContext, applicationScope)
    }

}