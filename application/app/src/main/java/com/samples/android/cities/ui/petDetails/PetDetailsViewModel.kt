package com.samples.android.cities.ui.petDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samples.android.cities.data.model.Pet
import com.samples.android.cities.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetDetailsViewModel @Inject constructor(
  private val repository: PetRepository
) : ViewModel() {

  private lateinit var view: PetDetailsView
  lateinit var petData: LiveData<Pet>
    private set

  fun setView(view: PetDetailsView) {
    this.view = view
  }

  fun setPet(data: Pet) {
    val petId = data.id

    petData = repository.getPetDetails(petId)
  }

  fun onPetSleepTap(pet: Pet) {
    viewModelScope.launch {
      repository.updatePet(pet.copy(isSleeping = !pet.isSleeping))
    }
  }

  fun onPetFeedTap(pet: Pet) {
    if (pet.isSleeping) {
      view.showFeedingSleepingPetMessage()
    } else {
      view.feedPet(pet)
    }
  }
}