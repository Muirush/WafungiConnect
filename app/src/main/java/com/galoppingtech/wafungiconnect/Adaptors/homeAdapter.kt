package com.galoppingtech.wafungiconnect.Adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.galoppingtech.wafungiconnect.Models.homeModel
import com.galoppingtech.wafungiconnect.databinding.HomeItemViewBinding

class homeAdapter (private  val homeList: ArrayList<homeModel>) :
RecyclerView.Adapter<homeAdapter.ViewHolder>(){

    private lateinit var binding: HomeItemViewBinding

    class ViewHolder(var homelistBinding: HomeItemViewBinding) :RecyclerView.ViewHolder(homelistBinding.root) {
    fun  bindItem(homeM:homeModel){
        homelistBinding.homeVideo.setImageResource(homeM.video)
        homelistBinding.homeDescription.text = homeM.description
        homelistBinding.homePostedBy.text = homeM.postedBy
        homelistBinding.homePostedOn.text = homeM.postedOn
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = HomeItemViewBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  homeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(homeList[position])
    }


}