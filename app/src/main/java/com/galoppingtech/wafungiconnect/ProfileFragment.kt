package com.galoppingtech.wafungiconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.galoppingtech.wafungiconnect.databinding.FragmentInfoBinding
import com.galoppingtech.wafungiconnect.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)


        binding.bottomNav.setupWithNavController(binding.root.findNavController())

        auth = FirebaseAuth.getInstance()
        val  user = auth.currentUser
        if (auth.currentUser == null){
            binding.profileName.text = ""
        }
        else{
            binding.profileName.text = user?.email
        }






    }
}