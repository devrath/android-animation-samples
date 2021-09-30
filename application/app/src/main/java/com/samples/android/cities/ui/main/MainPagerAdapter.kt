package com.samples.android.cities.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.samples.android.cities.R
import com.samples.android.cities.ui.main.myPets.MyPetsFragment
import com.samples.android.cities.ui.main.sleepingPets.SleepingPetsFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class MainPagerAdapter(private val context: Context, fm: FragmentManager) :
  FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

  private val fragments = listOf(MyPetsFragment(), SleepingPetsFragment())
  private val titles = arrayOf(R.string.tabMyCities, R.string.tabNight)

  override fun getItem(position: Int): Fragment = fragments[position]

  override fun getPageTitle(position: Int): CharSequence? {
    return context.resources.getString(titles[position])
  }

  override fun getCount(): Int = fragments.size
}