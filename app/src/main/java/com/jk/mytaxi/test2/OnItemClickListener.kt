package com.jk.mytaxi.test2

import android.view.View
import com.jk.mytaxi.test1.data.PoiList

interface OnItemClickListener {
    fun onItemClick(view: View, item: PoiList)
   // fun onItemClick()
}