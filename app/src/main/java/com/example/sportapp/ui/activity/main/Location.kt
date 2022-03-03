package com.example.sportapp.ui.activity.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.sportapp.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.CameraUpdateFactory

import com.google.android.gms.maps.model.MarkerOptions

import com.google.android.gms.maps.model.LatLng




class Location : AppCompatActivity(), OnMapReadyCallback {
    private var map: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_location)


        var mapFragment =
            getSupportFragmentManager().findFragmentById(R.id.mapView);
        //  mapFragment.getas
        //   mapFragment?.getMapAsync(this)
        (mapFragment as? SupportMapFragment)?.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        map?.setMyLocationEnabled(true);
        val sydney = LatLng(-34.0, 151.0)
        map!!.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
        )
        map!!.moveCamera(CameraUpdateFactory.newLatLng(sydney))

    }


}