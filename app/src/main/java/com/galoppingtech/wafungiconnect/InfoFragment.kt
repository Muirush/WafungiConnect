package com.galoppingtech.wafungiconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.galoppingtech.wafungiconnect.databinding.FragmentCreatePostBinding
import com.galoppingtech.wafungiconnect.databinding.FragmentInfoBinding


class InfoFragment : Fragment(R.layout.fragment_info) {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInfoBinding.bind(view)

        binding.bottomNav.setupWithNavController(binding.root.findNavController())
    }

}