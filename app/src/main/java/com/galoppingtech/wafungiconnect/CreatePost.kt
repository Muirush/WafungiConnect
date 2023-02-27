package com.galoppingtech.wafungiconnect

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
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
            hideViews()
        loginDlog()

            //findNavController().navigate(R.id.loginFragment)
         //   Snackbar.make(binding.root, "You need to register/login to Create a post",Snackbar.LENGTH_SHORT).show()

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

    private fun hideViews() {
        binding.apply {

        }
    }

    private fun loginDlog() {
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle("Ops... You don't have the rights")
        alertDialog.setMessage("To post your amazing videos, ensure you have and you are logged in to your Ufungi account")


        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "My Account"
        ) { dialog, which -> findNavController().navigate(R.id.loginFragment) }

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Later"
        ) { dialog, which -> findNavController().navigate(R.id.home) }

        alertDialog.setCancelable(false)
        alertDialog.show()


        val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

        val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10f
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams



    }
}