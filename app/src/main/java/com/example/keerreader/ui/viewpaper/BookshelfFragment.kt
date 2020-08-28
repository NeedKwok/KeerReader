package com.example.keerreader.ui.viewpaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.keerreader.databinding.FragmentBookshelfBinding
import com.example.keerreader.viewmodel.BookshelfViewModel

class BookshelfFragment : Fragment() {

    private lateinit var binding:FragmentBookshelfBinding
    //private lateinit var bookshelfViewModel: BookshelfViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookshelfBinding.inflate(inflater, container, false)
        val textView = binding.textBookshelf

        val bookshelfViewModel : BookshelfViewModel by viewModels()

        bookshelfViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return binding.root
    }
}