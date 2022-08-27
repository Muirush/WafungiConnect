package com.galoppingtech.wafungiconnect.Auth

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.galoppingtech.wafungiconnect.R
import com.galoppingtech.wafungiconnect.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment(R.layout.fragment_register){
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

        findNavController().navigate(R.id.validatePhone)

        auth.createUserWithEmailAndPassword(email, pwd)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {

                    //OTP Dialog
                    //createOTPDialog()

                    // Sign in success, update UI with the signed-in user's information
                  findNavController().navigate(R.id.validatePhone)
                    val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.

                  //  Snackbar.make(binding.root, "Failed to register", Snackbar.LENGTH_SHORT).show()

                }
            }
    }
    //OTP dialog function
    fun createOTPDialog(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("OTP Authentication")
            .setIcon(R.drawable.otp)
            .apply {
                setMessage("We are trying...")
            }
            .create()
            .show()


    }
}