package com.samples.android.cities.preferences

interface MenageriePreferences {

  fun isUserLoggedIn(): Boolean

  fun setUserLoggedIn(isLoggedIn: Boolean)
}