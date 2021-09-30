package com.raywenderlich.android.menagerie.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.android.menagerie.preferences.MenageriePreferences
import com.raywenderlich.android.menagerie.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
  private val menageriePreferences: MenageriePreferences,
  private val repository: PetRepository
) : ViewModel() {

  private lateinit var view: SettingsView

  val pets by lazy { repository.getPets() }

  fun setView(view: SettingsView) {
    this.view = view
  }

  fun logOut() {
    menageriePreferences.setUserLoggedIn(false)
    view.onUserLoggedOut()
  }

  fun onPetSleepTap() {
    viewModelScope.launch {
      val pets = repository.getPetData()

      val arePetsAsleep = pets.all { it.isSleeping }
      val updatedPets = pets.map { pet -> pet.copy(isSleeping = !arePetsAsleep) }

      repository.updatePets(updatedPets)
    }
  }
}