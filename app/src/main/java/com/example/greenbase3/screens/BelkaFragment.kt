package com.example.greenbase3.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.greenbase3.R
import com.example.greenbase3.databinding.FragmentBelkaBinding

class BelkaFragment : Fragment() {

    private lateinit var binding: FragmentBelkaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBelkaBinding.inflate(layoutInflater, container, false)
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
    }}