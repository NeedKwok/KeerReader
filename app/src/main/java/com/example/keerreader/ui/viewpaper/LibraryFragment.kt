package com.example.keerreader.ui.viewpaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.keerreader.R
import com.example.keerreader.databinding.FragmentBookshelfBinding
import com.example.keerreader.databinding.FragmentLibraryBinding
import com.example.keerreader.viewmodel.BookshelfViewModel
import com.example.keerreader.viewmodel.LibraryViewModel

class LibraryFragment : Fragment() {

    private lateinit var binding:FragmentLibraryBinding
    //private lateinit var libraryViewModel: LibraryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLibraryBinding.inflate(inflater, container, false)
        val textView = binding.textLibrary

        val libraryViewModel : LibraryViewModel by viewModels()

        libraryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return binding.root
    }
}