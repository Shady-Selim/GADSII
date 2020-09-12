package com.example.gadsii.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gadsii.R
import com.example.gadsii.data.GADSData
import kotlinx.android.synthetic.main.rv_row.view.*

class MainFragmentAdapter(val dataList: ArrayList<GADSData>)  : RecyclerView.Adapter<MainFragmentAdapter.JobsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_row, parent, false)
        return JobsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.bindItems(dataList[position])
    }

    class JobsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(data: GADSData) = with(itemView) {
            tvName.text = data.name
            tvCountry.text = data.country
            imgMDataImg.load(data.badgeUrl)
        }
    }
}