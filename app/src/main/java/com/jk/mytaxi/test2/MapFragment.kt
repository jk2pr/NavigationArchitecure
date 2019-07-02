package com.jk.mytaxi.test2

import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jk.mytaxi.test1.data.Coordinate
import kotlin.math.roundToInt

class MapFragment : SupportMapFragment(), OnMapReadyCallback {


    override fun onActivityCreated(p0: Bundle?) {
        super.onActivityCreated(p0)
        getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {


        val d = arguments?.getSerializable("LAT_LONG") as Coordinate
        val loc = LatLng(d.latitude, d.longitude)
        googleMap.addMarker(MarkerOptions().position(loc).title(d.latitude.roundToInt().toString().plus(",").plus(d.longitude.roundToInt())))
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                loc,
                12.0f
            )
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(loc))
    }
}