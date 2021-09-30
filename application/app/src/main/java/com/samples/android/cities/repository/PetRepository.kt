package com.samples.android.cities.repository

import androidx.lifecycle.LiveData
import com.samples.android.cities.data.model.Pet

interface PetRepository {

  fun getPets(): LiveData<List<Pet>>

  suspend fun getPetData(): List<Pet>

  fun getSleepingPets(): LiveData<List<Pet>>

  suspend fun updatePet(pet: Pet)

  suspend fun insertPets(pets: List<Pet>)

  suspend fun updatePets(pets: List<Pet>)

  fun getPetDetails(petId: String): LiveData<Pet>
}