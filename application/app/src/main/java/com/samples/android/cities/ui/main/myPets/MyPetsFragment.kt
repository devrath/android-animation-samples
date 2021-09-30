package com.samples.android.cities.ui.main.myPets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.samples.android.cities.data.model.Pet
import com.samples.android.cities.databinding.FragmentMyPetsBinding
import com.samples.android.cities.ui.main.adapter.PetAdapter
import com.samples.android.cities.ui.main.helper.SimpleTouchHelperCallback
import com.samples.android.cities.ui.petDetails.PetDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPetsFragment : Fragment(), MyPetsView {
  private val viewModel: MyPetsViewModel by viewModels()

  private var binding: FragmentMyPetsBinding? = null
  private val adapter by lazy { PetAdapter(::showPetDetails, viewModel::onPetSleepClick) }
  private val simpleTouchHelperCallback by lazy {
    SimpleTouchHelperCallback(
      onItemMoved = adapter::onItemMoved,
      onItemSwiped = adapter::onItemSwiped
    )
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentMyPetsBinding.inflate(inflater, container, false)

    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.setView(this)
    val petList = binding?.petList ?: return
    val itemTouchHelper = ItemTouchHelper(simpleTouchHelperCallback)

    petList.layoutManager = LinearLayoutManager(requireActivity())
    petList.adapter = adapter
    itemTouchHelper.attachToRecyclerView(petList)

    viewModel.myPets.observe(viewLifecycleOwner, { myPets ->
      if (myPets != null) {
        adapter.setData(myPets)
      }
    })
  }

  private fun showPetDetails(pet: Pet, transitionPairs: Array<Pair<View, String>>) {
    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
      requireActivity(),
      *transitionPairs
    )

    startActivity(PetDetailsActivity.getIntent(requireActivity(), pet), options.toBundle())
  }
}