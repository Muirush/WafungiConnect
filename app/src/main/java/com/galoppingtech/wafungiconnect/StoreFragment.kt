package com.galoppingtech.wafungiconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.galoppingtech.wafungiconnect.Adaptors.storeAdapter
import com.galoppingtech.wafungiconnect.Models.storeModel
import com.galoppingtech.wafungiconnect.databinding.FragmentProfileBinding
import com.galoppingtech.wafungiconnect.databinding.FragmentStoreBinding


class StoreFragment : Fragment(R.layout.fragment_store) {
    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStoreBinding.bind(view)

        binding.bottomNav.setupWithNavController(binding.root.findNavController())


        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.storeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = storeAdapter(creatSlist())
        }
    }

    private fun creatSlist(): ArrayList<storeModel> {
        return arrayListOf<storeModel>(
            storeModel(
                R.drawable.ic_undraw_happy_music_g6wc,
                "Synth Voices",
                "Enjoy the best Synth voices for modern upbeat music"
            ),
            storeModel(
                R.drawable.ic_undraw_happy_music_g6wc,
                "Synth Voices",
                "Enjoy the best Synth voices for modern upbeat music"
            ),
            storeModel(
                R.drawable.ic_undraw_happy_music_g6wc,
                "Synth Voices",
                "Enjoy the best Synth voices for modern upbeat music"
            ),
            storeModel(
                R.drawable.ic_undraw_happy_music_g6wc,
                "Synth Voices",
                "Enjoy the best Synth voices for modern upbeat music"
            ),
            storeModel(
                R.drawable.ic_undraw_happy_music_g6wc,
                "Synth Voices",
                "Enjoy the best Synth voices for modern upbeat music"
            )

        )

    }
}