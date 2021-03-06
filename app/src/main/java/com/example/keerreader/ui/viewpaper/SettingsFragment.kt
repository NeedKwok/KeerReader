package com.example.keerreader.ui.viewpaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.keerreader.databinding.FragmentSettingsBinding
import com.example.keerreader.viewmodel.SettingsViewModel

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    //private lateinit var settingsViewModel: settingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val textView = binding.textSettings

        val settingsViewModel : SettingsViewModel by viewModels()

        settingsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return binding.root
    }
}