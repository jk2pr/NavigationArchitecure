package com.jk.mytaxi.test1.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jk.mytaxi.R
import com.jk.mytaxi.test1.data.PoiList
import com.jk.mytaxi.databinding.ListItemBinding
import com.jk.mytaxi.test2.OnItemClickListener


class MapAdapter(private val items: ArrayList<PoiList>) : RecyclerView.Adapter<MapAdapter.ViewHolder>(),
    OnItemClickListener {


    lateinit var context: Context

    override fun onItemClick(view: View, item: PoiList) {


        val data=Bundle()
        data.putSerializable("LAT_LONG",item.coordinate)
        view.findNavController().navigate(R.id.action_listFragment_to_mapFragment, data)

        //  println(Toast.makeText(context, "CLicked", Toast.LENGTH_SHORT).show())


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context
        val binding = DataBindingUtil
            .inflate<ListItemBinding>(LayoutInflater.from(parent.context), R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    fun addItems(found: List<PoiList>) {
        items.addAll(found)
        notifyItemRangeInserted(0, found.size - 1)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }


    inner class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(plist: PoiList) {

            with(binding) {
                item = plist
                itemClickListener = this@MapAdapter


                tvTitle.text = plist.fleetType
                when {
                    plist.fleetType.contentEquals("TAXI") -> imgFleetType.setImageDrawable(
                        ContextCompat.getDrawable(
                            imgFleetType.context,
                            R.drawable.ic_iconfinder_a3_09_1318068
                        )
                    )
                    plist.fleetType.contentEquals("POOLING") -> imgFleetType.setImageDrawable(
                        ContextCompat.getDrawable(
                            imgFleetType.context,
                            R.drawable.ic_directions_car_black_24dp
                        )
                    )
                }

            }

        }

    }
}