package com.galoppingtech.wafungiconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.galoppingtech.wafungiconnect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_WafungiConnect)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
//        binding.btLogin.setOnClickListener(){
//            login()
//        }
        
    }

//    private fun login() {
//       val name=  binding.loginUsername.text.toString().trim()
//        val pass = binding.loginPassword.text.toString().trim()
//        if (name.isNullOrEmpty()&& pass.isNullOrEmpty()){
//            Toast.makeText(this,"Cannot be empty",Toast.LENGTH_LONG).show()
//        }
//         else{
//             Toast.makeText(this,"Hello "+name,Toast.LENGTH_SHORT).show()
//        }
//    }
}