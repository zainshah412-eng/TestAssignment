package com.example.listing_presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listing_domain.model.University
import com.example.listing_presentation.databinding.ViewHolderUniversityBinding

class ListingAdapter(
    var onItemClickListner: OnItemClickListener,
) : RecyclerView.Adapter<ListingAdapter.MyViewHolder>() {

    private var list = listOf<University>()

    fun setData(list: List<University>) {
        try {
            this.list = list
            notifyDataSetChanged()
        } catch (e:Exception){
            Log.wtf("Error",e.toString())
        }

    }

    inner class MyViewHolder(val viewDataBinding: ViewHolderUniversityBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ViewHolderUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.apply {
            val item = list[position]

            tvHeadlines.text = item.name
            tvContent.text = item.stateProvince

            box.setOnClickListener {
                onItemClickListner.onItemClicked(item)
            }
        }

    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}

interface OnItemClickListener {
    fun onItemClicked(item: University)

}