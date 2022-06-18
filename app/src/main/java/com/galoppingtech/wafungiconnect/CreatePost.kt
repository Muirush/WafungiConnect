package com.galoppingtech.wafungiconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.galoppingtech.wafungiconnect.databinding.FragmentCreatePostBinding
import com.galoppingtech.wafungiconnect.databinding.FragmentHomeBinding


class CreatePost : Fragment(R.layout.fragment_create_post) {
    private var _binding: FragmentCreatePostBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCreatePostBinding.bind(view)

        binding.bottomNav.setupWithNavController(binding.root.findNavController())
    }
}