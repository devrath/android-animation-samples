package com.raywenderlich.android.menagerie.ui.main.myPets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.android.menagerie.data.model.Pet
import com.raywenderlich.android.menagerie.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPetsViewModel @Inject constructor(
  private val repository: PetRepository
) : ViewModel() {

  private lateinit var view: MyPetsView

  val myPets by lazy { repository.getPets() }

  fun setView(view: MyPetsView) {
    this.view = view
  }

  fun onPetSleepClick(pet: Pet) {
    viewModelScope.launch {
      repository.updatePet(pet.copy(isSleeping = !pet.isSleeping))
    }
  }
}