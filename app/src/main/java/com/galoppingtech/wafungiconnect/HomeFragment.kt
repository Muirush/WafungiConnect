package com.galoppingtech.wafungiconnect

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.galoppingtech.wafungiconnect.Adaptors.homeAdapter
import com.galoppingtech.wafungiconnect.Adaptors.storeAdapter
import com.galoppingtech.wafungiconnect.Models.homeModel
import com.galoppingtech.wafungiconnect.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)




        binding.bottomNav.setupWithNavController(binding.root.findNavController())

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (auth.currentUser == null){
            binding.apply {
               useProfileName.text = "Hi Anonymous"
            }
        }
        else{
            binding.useProfileName.text = "Hi "+currentUser?.email
        }

        binding.useProfileName.setOnClickListener(){
            findNavController().navigate(R.id.profileFragment)
        }
         setUpRecyclerView()



    }

    private fun setUpRecyclerView() {
        binding.homeRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter(createList())
        }
    }

    private fun createList(): ArrayList<homeModel> {
        return  arrayListOf<homeModel>(

            homeModel(
                R.drawable.piano,
                "Minor chords in Sebenne",
            "Simon Muiruri",
                "24.2.2023"
            ),
            homeModel(
                R.drawable.piano,
                "Minor chords in Sebenne",
                "Simon Muiruri",
                "24.2.2023"
            ),
            homeModel(
                R.drawable.piano,
                "Minor chords in Sebenne",
                "Simon Muiruri",
                "24.2.2023"
            ),
            homeModel(
                R.drawable.piano,
                "Minor chords in Sebenne",
                "Simon Muiruri",
                "24.2.2023"
            ),
            homeModel(
                R.drawable.piano,
                "Minor chords in Sebenne",
                "Simon Muiruri",
                "24.2.2023"
            ),
            homeModel(
                R.drawable.piano,
                "Minor chords in Sebenne",
                "Simon Muiruri",
                "24.2.2023"
            )


        )

    }
}