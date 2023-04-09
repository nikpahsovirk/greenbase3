package com.example.greenbase3.screens

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.greenbase3.MainActivity
import com.example.greenbase3.R
import com.example.greenbase3.databinding.FragmentHomeBinding
import com.example.greenbase3.mMap
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
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
        val fire1 = LatLng(62.620677, 128.485716)
        val fire2 = LatLng(62.474559, 128.162082)
        val fire3 = LatLng(62.674708, 127.998236)
        val fire4 = LatLng(62.349194, 127.499573)
        val fire5 = LatLng(62.163486, 127.955494)
        val fire6 = LatLng(62.372327, 128.974190)
        val drone1 = LatLng(62.779199, 126.620650)
        val drone2 = LatLng(65.989477, 122.949446)
        val drone3 = LatLng(65.204742, 115.448963)
        val station1 = LatLng(64.320435, 124.857024)
        val station2 = LatLng(62.186357, 115.162046)
        val station3 = LatLng(66.023215, 133.039310)
        val station4 = LatLng(67.566925, 146.240982)

        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.station) })
                .position(station4)
                .title("Станция-Юпитер")
        )
        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.station) })
                .position(station3)
                .title("Станция-Сатурн")
        )
        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.station) })
                .position(station2)
                .title("Станция-Венера")
        )
        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.station) })
                .position(station1)
                .title("Станция-Восток")
        )


        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.firemark) })
                .position(fire1)
                .title("Пожар подтверждён")
        )

        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.drone) })
                .position(drone1)
                .title("Дрон_1 Модель: БК-20")
        )
        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.drone) })
                .position(drone2)
                .title("Дрон_2 Модель: БК-20")
        )
        mMap.addMarker(
                MarkerOptions()
                    .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.drone) })
                    .position(drone3)
                    .title("Дрон_3 Модель: БК-20")
                )

        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.firemark) })
                .position(fire2)
                .title("Пожар подтверждён")
        )

        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.firemark) })
                .position(fire3)
                .title("Пожар подтверждён")
        )

        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.firemark) })
                .position(fire4)
                .title("Пожар подтверждён")
        )

        mMap.addMarker(
            MarkerOptions()

                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.firemark) })
                .position(fire5)
                .title("Пожар подтверждён"))

        mMap.addMarker(
            MarkerOptions()
                .icon(context?.let { bitmapDescriptorFromVector(it.applicationContext, R.drawable.firemark) })
                .position(fire6)
                .title("Пожар подтверждён"))

        mMap.addMarker(
            MarkerOptions()
            .position(yakutsk)
            .title("Marker in Yakutsk"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(yakutsk))
        mMap.uiSettings.isZoomControlsEnabled = true
    }

    private fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor {
        val vectorDrawable: Drawable? = ContextCompat.getDrawable(context, vectorResId)
        vectorDrawable?.setBounds(
            0, 0, vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight
        )
        val bitmap = Bitmap.createBitmap(
            vectorDrawable!!.intrinsicWidth,
            vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }
    }


