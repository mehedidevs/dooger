package com.mehedi.dogger.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.mehedi.dogger.database.DogDao
import com.mehedi.dogger.database.DogDatabase

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DogDatabase {
        return DogDatabase.getInstance(context)
    }

    @Provides
    fun provideDao(exampleDatabase: DogDatabase): DogDao {
        return exampleDatabase.getExampleDao()
    }

}