package com.jk.mytaxi.test1.data

import java.io.Serializable

data class PoiList (

    val id : Int,
    val coordinate : Coordinate,
    val fleetType : String,
    val heading : Double
)