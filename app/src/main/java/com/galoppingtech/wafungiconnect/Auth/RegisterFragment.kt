package com.galoppingtech.wafungiconnect.Auth

import android.app.Fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.galoppingtech.wafungiconnect.R
import com.galoppingtech.wafungiconnect.databinding.FragmentLoginBinding
import com.galoppingtech.wafungiconnect.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegisterBinding.bind(view)


        initViews()
        auth = FirebaseAuth.getInstance()


    }

    private fun initViews() {
        binding.rButton.setOnClickListener() {
            val name = binding.regUsername.text.toString().trim()
            val email = binding.regEmail.text.toString().trim()
            val pwd = binding.regPassword.text.toString().trim()

            if (name == "" && pwd == "") {
                binding.apply {
                    regUsername.error = "Username required"
                    regEmail.error = "Email required"
                    regPassword.error = "Password Required"
                }

            } else {
                upFunction()

            }
        }



    }

    private fun upFunction() {
        val name = binding.regUsername.text.toString().trim()
        val email = binding.regEmail.text.toString().trim()
        val pwd  = binding.regPassword.text.toString().trim()

        auth.createUserWithEmailAndPassword(email, pwd)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                  findNavController().navigate(R.id.loginFragment)
                    val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.

                    Snackbar.make(binding.root, "Failured", Snackbar.LENGTH_SHORT).show()

                }
            }
    }
}