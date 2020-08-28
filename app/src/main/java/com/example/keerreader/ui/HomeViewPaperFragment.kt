package com.example.keerreader.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.keerreader.R
import com.example.keerreader.adapter.HomeViewPaperAdapter
import com.example.keerreader.databinding.FragmentHomeViewPaperBinding
import com.google.android.material.tabs.TabLayoutMediator

import com.example.keerreader.adapter.BOOKSHELF_INDEX
import com.example.keerreader.adapter.LIBRARY_INDEX

class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeViewPaperBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = HomeViewPaperAdapter(this)

        // Set the icon and text for each tab
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        //(activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            BOOKSHELF_INDEX -> R.drawable.garden_tab_selector
            LIBRARY_INDEX -> R.drawable.plant_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            BOOKSHELF_INDEX -> getString(R.string.bookshelf_title)
            LIBRARY_INDEX -> getString(R.string.library_title)
            else -> null
        }
    }
}