package com.samples.android.cities.ui.petDetails

import com.samples.android.cities.data.model.Pet

interface PetDetailsView {

  fun showFeedingSleepingPetMessage()

  fun feedPet(pet: Pet)
}