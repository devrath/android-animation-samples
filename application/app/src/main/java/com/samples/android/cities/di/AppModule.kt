package com.samples.android.cities.di

import android.content.Context
import android.content.SharedPreferences
import com.samples.android.cities.database.MenagerieDatabase
import com.samples.android.cities.database.PetDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

  companion object {
    private const val KEY_PREFERENCES = "menagerie_preferences"
  }

  @Provides
  @Singleton
  fun provideDatabase(@ApplicationContext context: Context): MenagerieDatabase {
    return MenagerieDatabase.buildDatabase(context)
  }

  @Provides
  @Singleton
  fun providePetDao(menagerieDatabase: MenagerieDatabase): PetDao {
    return menagerieDatabase.petDao()
  }

  @Provides
  @Singleton
  fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
    return context.getSharedPreferences(KEY_PREFERENCES, Context.MODE_PRIVATE)
  }
}