package com.umc.week5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umc.week5.databinding.ItemDataBinding

class DataRVAdapter(private val dataList:ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding:ItemDataBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(data:Data){
            viewBinding.textView.text = data.title

        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int{
        return dataList.size
    }

}