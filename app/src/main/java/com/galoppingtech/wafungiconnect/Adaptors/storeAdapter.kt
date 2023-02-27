package com.galoppingtech.wafungiconnect.Adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.galoppingtech.wafungiconnect.Models.storeModel
import com.galoppingtech.wafungiconnect.databinding.StoreItemViewBinding

class storeAdapter (private val storeList: ArrayList<storeModel>):
RecyclerView.Adapter<storeAdapter.ViewHolder>(){
    private  lateinit var  binding: StoreItemViewBinding


    class ViewHolder(var storeListBinding: StoreItemViewBinding) :RecyclerView.ViewHolder(storeListBinding.root) {
        fun bindItem(storeM:storeModel){
            storeListBinding.itemImage.setImageResource(storeM.image)
            storeListBinding.ItemTitle.text =storeM.itrmName
            storeListBinding.ItemDescription.text = storeM.itemDetails
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= StoreItemViewBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return storeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
holder.bindItem(storeList[position])
    }
}