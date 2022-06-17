package com.galoppingtech.wafungiconnect.Auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.galoppingtech.wafungiconnect.R
import com.galoppingtech.wafungiconnect.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding : FragmentLoginBinding?= null
    private  val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)
        initViews()



}

    private fun initViews() {
        TODO("Not yet implemented")
    }
