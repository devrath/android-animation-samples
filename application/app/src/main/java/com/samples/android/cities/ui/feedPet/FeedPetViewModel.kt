package com.samples.android.cities.ui.feedPet

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.samples.android.cities.data.model.Pet
import com.samples.android.cities.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedPetViewModel @Inject constructor(
  private val repository: PetRepository
) : ViewModel() {

  private lateinit var view: FeedPetView
  lateinit var petData: LiveData<Pet>
    private set

  fun setView(view: FeedPetView) {
    this.view = view
  }

  fun setPet(data: Pet) {
    petData = repository.getPetDetails(data.id)
  }
}
