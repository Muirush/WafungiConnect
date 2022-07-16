package com.galoppingtech.wafungiconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.galoppingtech.wafungiconnect.databinding.FragmentCreatePostBinding
import com.galoppingtech.wafungiconnect.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class CreatePost : Fragment(R.layout.fragment_create_post) {

    private var _binding: FragmentCreatePostBinding? = null
    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCreatePostBinding.bind(view)

        auth = FirebaseAuth.getInstance()
        binding.bottomNav.setupWithNavController(binding.root.findNavController())

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser == null){
            Snackbar.make(binding.root, "You need to register/login to Create a post",Snackbar.LENGTH_SHORT).show()
            binding.link.setOnClickListener(){

                findNavController().navigate(R.id.loginFragment)
            }

        }
        else{
            binding.apply {
                t.visibility = View.VISIBLE
                link.visibility = View.INVISIBLE
                t.setOnClickListener {
                    auth.signOut()
                    findNavController().navigate(R.id.loginFragment)
                }
            }

        }
    }
}