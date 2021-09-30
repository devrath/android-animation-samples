package com.samples.android.cities.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.samples.android.cities.data.model.Pet
import com.samples.android.cities.database.PetDao
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(
  private val petDao: PetDao
) : PetRepository {

  override fun getPets(): LiveData<List<Pet>> = petDao.getPets().map { pets ->
    pets.sortedBy { it.name }
  }

  override suspend fun getPetData(): List<Pet> = petDao.getPetData()

  override fun getSleepingPets(): LiveData<List<Pet>> = petDao.getSleepingPets().map { pets ->
    pets.sortedBy { it.name }
  }

  override suspend fun updatePet(pet: Pet) = petDao.updatePet(pet)
  override suspend fun insertPets(pets: List<Pet>) = petDao.insertPets(pets)
  override suspend fun updatePets(pets: List<Pet>) = petDao.updatePets(pets)

  override fun getPetDetails(petId: String): LiveData<Pet> = petDao.getPetDetails(petId)
}