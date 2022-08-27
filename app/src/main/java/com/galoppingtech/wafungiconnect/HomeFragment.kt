package com.galoppingtech.wafungiconnect

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.galoppingtech.wafungiconnect.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)




        binding.bottomNav.setupWithNavController(binding.root.findNavController())

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        binding.useProfileName.text = currentUser.toString()
        binding.useProfileName.setOnClickListener(){
            findNavController().navigate(R.id.profileFragment)
        }


    }
}