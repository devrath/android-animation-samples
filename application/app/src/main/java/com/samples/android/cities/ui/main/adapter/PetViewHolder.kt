package com.samples.android.cities.ui.main.adapter

import android.view.View
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.samples.android.cities.R
import com.samples.android.cities.data.model.Pet
import com.samples.android.cities.databinding.ItemPetBinding

class PetViewHolder(
  private val binding: ItemPetBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun bindData(
    data: Pet,
    onItemClick: (Pet, Array<Pair<View, String>>) -> Unit,
    onPetSleepClick: (Pet) -> Unit
  ) {
    binding.petAvatar.load(data.image)
    binding.petName.text = data.name
    binding.petSleep.setImageResource(if (data.isSleeping) R.drawable.ic_bedtime_24 else R.drawable.ic_sunny_24)

    binding.petSleep.setOnClickListener { onPetSleepClick(data) }
    binding.root.setOnClickListener {
      val petAvatar: Pair<View, String> =
        Pair.create(binding.petAvatar, itemView.resources.getString(R.string.transitionPetAvatar))
      val petSleep: Pair<View, String> =
        Pair.create(binding.petSleep, itemView.resources.getString(R.string.transitionPetSleep))

      onItemClick(data, arrayOf(petAvatar, petSleep))
    }
  }
}