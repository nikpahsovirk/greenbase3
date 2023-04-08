package com.example.greenbase3.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.greenbase3.R
import com.example.greenbase3.databinding.FragmentHomeBinding
import com.example.greenbase3.mMap
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class HomeFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.map, HomeFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.map, DiaryFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.map, ProfileFragment()).commit()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

        val yakutsk = LatLng(62.0397, 129.7422)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        mapFragment.getMapAsync { googleMap ->
            googleMap.setOnMapLoadedCallback {
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(yakutsk, 3.7F))
            }
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val yakutsk = LatLng(62.0397, 129.7422)

        mMap.addMarker(
            MarkerOptions()
            .position(yakutsk)
            .title("Marker in Yakutsk"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(yakutsk))
        mMap.uiSettings.isZoomControlsEnabled = true
    }



}