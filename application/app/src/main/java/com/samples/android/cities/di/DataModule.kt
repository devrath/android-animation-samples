package com.samples.android.cities.di

import com.samples.android.cities.preferences.MenageriePreferences
import com.samples.android.cities.preferences.MenageriePreferencesImpl
import com.samples.android.cities.repository.PetRepository
import com.samples.android.cities.repository.PetRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

  @Binds
  abstract fun repository(petRepositoryImpl: PetRepositoryImpl): PetRepository

  @Binds
  abstract fun preferences(menageriePreferencesImpl: MenageriePreferencesImpl): MenageriePreferences
}