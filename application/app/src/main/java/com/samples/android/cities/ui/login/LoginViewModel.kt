package com.samples.android.cities.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samples.android.cities.preferences.MenageriePreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val menageriePreferences: MenageriePreferences
) : ViewModel() {

  private lateinit var view: LoginView

  fun setView(view: LoginView) {
    this.view = view
  }

  fun start() {
    if (menageriePreferences.isUserLoggedIn()) {
      view.showPets()
    }
  }

  fun logIn() {
    viewModelScope.launch {
      delay(3000)
      menageriePreferences.setUserLoggedIn(true)

      view.onLoggedIn()
    }
  }
}