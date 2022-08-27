package com.galoppingtech.wafungiconnect.Auth

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.galoppingtech.wafungiconnect.MainActivity
import com.galoppingtech.wafungiconnect.R
import com.galoppingtech.wafungiconnect.databinding.FragmentRegisterBinding
import com.galoppingtech.wafungiconnect.databinding.FragmentValidatePhoneBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit


class ValidatePhone : Fragment(R.layout.fragment_validate_phone) {

    private var storedVerificationId: String? = ""
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentValidatePhoneBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentValidatePhoneBinding.bind(view)


        initViews()
        binding.apply {
            ValidCodeButton.visibility = View.INVISIBLE
            otp.visibility = View.INVISIBLE
        }
        auth = FirebaseAuth.getInstance()
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                findNavController().navigate(R.id.loginFragment)


               // signInWithPhoneAuthCredential(credential)

            }


            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
               // Log.w(TAG, "onVerificationFailed", e)
                Snackbar.make(binding.root, "OTP code provided did not work", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.RED).show()


                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request


                } else if (e is FirebaseTooManyRequestsException) {
                    Snackbar.make(binding.root, "Too many requests", Snackbar.LENGTH_SHORT)
                        .show()
                    // The SMS quota for the project has been exceeded
                }


                // Show a message and update the UI
            }


            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
              //  Log.d(TAG, "onCodeSent:$verificationId")
                Snackbar.make(binding.root, "OTP code has been sent to your phone", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.BLUE).show()


                // Save verification ID and resending token so we can use them later
                storedVerificationId = verificationId
                resendToken = token
            }
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {

            auth.signInWithCredential(credential).addOnCompleteListener {task ->

                if (task.isSuccessful){
                    findNavController().navigate(R.id.loginFragment)

                }
                else{
                    Snackbar.make(binding.root, "OTP code provided did not work", Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(Color.RED).show()

                }
            }
    }

    private fun initViews() {

        binding.getCodeButton.setOnClickListener(){
            val phoneNo = binding.phone.text.toString().trim()

            if (phoneNo.isEmpty()){
                binding.apply {
                    phone.error ="Please provide a phone number"
                }


            }
            else{
                startPhoneNumberVerification(phoneNo)
                binding.apply {
                    ValidCodeButton.visibility = View.VISIBLE
                    otp.visibility = View.VISIBLE
                }
            }

        }

        binding.ValidCodeButton.setOnClickListener(){
            val code1=binding.otp.text.toString()
            if (code1.isEmpty())
            {
                Snackbar.make(binding.root, "Provide a valid OTP code", Snackbar.LENGTH_SHORT).setBackgroundTint(Color.RED).show()
            }
            else{
                Snackbar.make(binding.root, "Your code is: $code1", Snackbar.LENGTH_SHORT).show()
                verifyPhoneNumberWithCode(storedVerificationId,code1)
            }


        }

    }


    private fun startPhoneNumberVerification(phoneNumber: String) {

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)

    }

    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {

        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        signInWithPhoneAuthCredential(credential)
    }


    private fun resendVerificationCode(
        phoneNumber: String,
        token: PhoneAuthProvider.ForceResendingToken?
    ) {
        val optionsBuilder = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this.requireActivity())                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
        if (token != null) {
            optionsBuilder.setForceResendingToken(token) // callback's ForceResendingToken
        }
        PhoneAuthProvider.verifyPhoneNumber(optionsBuilder.build())
    }


}