package com.samples.android.cities.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

  private lateinit var view: MainView

  fun setView(view: MainView) {
    this.view = view
  }
}