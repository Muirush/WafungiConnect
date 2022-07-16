package com.galoppingtech.wafungiconnect.Auth

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.DialogFragmentNavigatorDestinationBuilder
import androidx.navigation.fragment.findNavController
import com.galoppingtech.wafungiconnect.R
import com.galoppingtech.wafungiconnect.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentLoginBinding? = null


    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)


        initViews()
        auth = FirebaseAuth.getInstance()


    }

    private fun initViews() {




        binding.lButton.setOnClickListener(){
            val name = binding.loginEmail.text.toString().trim()
            val pwd  = binding.loginPassword.text.toString().trim()

            if (name =="" && pwd == ""){
                binding.apply {
                    loginEmail.error = "Username required"
                    loginPassword.error = "Password Required"
                }

            }
            else{
                inFunction()
            }

        }

        binding.forgetPassword.setOnClickListener(){

            Snackbar.make(binding.root,"Coming soon...", Snackbar.LENGTH_SHORT).show()
        }

        binding.newHere.setOnClickListener(){
            findNavController().navigate(R.id.registerFragment)

        }

    }

    private fun inFunction() {

        val name = binding.loginEmail.text.toString().trim()
        val pwd  = binding.loginPassword.text.toString().trim()

        auth.signInWithEmailAndPassword(name, pwd).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                findNavController().navigate(R.id.home)

                val user = auth.currentUser
                //updateUI(user)

                // pass user
            } else {
                Snackbar.make(binding.root,"Cannot sign in", Snackbar.LENGTH_SHORT).show()
            }

        }



    }
}