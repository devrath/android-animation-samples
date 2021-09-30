package com.samples.android.cities.ui.main.sleepingPets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samples.android.cities.data.model.Pet
import com.samples.android.cities.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SleepingPetsViewModel @Inject constructor(
  private val repository: PetRepository
) : ViewModel() {

  private lateinit var view: SleepingPetsView

  val sleepingPets by lazy { repository.getSleepingPets() }

  fun setView(view: SleepingPetsView) {
    this.view = view
  }

  fun onPetSleepClick(pet: Pet) {
    viewModelScope.launch {
      repository.updatePet(pet.copy(isSleeping = !pet.isSleeping))
    }
  }
}