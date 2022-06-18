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


class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)


        initViews()


    }

    private fun initViews() {




        binding.lButton.setOnClickListener(){
            val name = binding.loginUsername.text.toString().trim()
            val pwd  = binding.loginPassword.text.toString().trim()

            if (name =="" && pwd == ""){
                binding.apply {
                    binding.loginUsername.error = "Username required"
                    binding.loginPassword.error = "Password Required"
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
            findNavController().navigate(R.id.validatePhone)

        }

    }

    private fun inFunction() {
        findNavController().navigate(R.id.home)
    }
}