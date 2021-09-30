package com.samples.android.cities.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.samples.android.cities.data.model.Pet
import com.samples.android.cities.databinding.ItemPetBinding

class PetAdapter(
  private val onItemClick: (Pet, Array<Pair<View, String>>) -> Unit,
  private val onPetSleepClick: (Pet) -> Unit
) : RecyclerView.Adapter<PetViewHolder>() {

  private val items = mutableListOf<Pet>()

  override fun getItemCount(): Int = items.size

  fun setData(data: List<Pet>) {
    this.items.clear()
    this.items.addAll(data)
    notifyDataSetChanged()
  }

  fun onItemMoved(oldPosition: Int, newPosition: Int) {
    val itemToReplace = items[oldPosition]
    items.remove(itemToReplace)

    val positionToMove = if (oldPosition > newPosition) newPosition else newPosition - 1
    items.add(positionToMove, itemToReplace)

    notifyItemMoved(oldPosition, positionToMove)
  }

  fun onItemSwiped(position: Int) {
    items.removeAt(position)
    notifyItemRemoved(position)
  }

  fun getItem(position: Int) = items[position]

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
    val binding = ItemPetBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    return PetViewHolder(binding)
  }

  override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
    holder.bindData(items[position], onItemClick, onPetSleepClick)
  }
}