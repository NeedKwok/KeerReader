package com.example.keerreader.ui.viewpaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.keerreader.adapter.BookAdapter
import com.example.keerreader.databinding.FragmentBookshelfBinding
import com.example.keerreader.utilities.InjectorUtils
import com.example.keerreader.viewmodel.BookshelfViewModel

class BookshelfFragment : Fragment() {

    private val viewModel : BookshelfViewModel by viewModels {
        InjectorUtils.provideBookshelfViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookshelfBinding.inflate(inflater, container, false)
        context ?:return binding.root

        val adapter = BookAdapter()
        binding.bookList.adapter = adapter
        subscribeUi(adapter,binding)

        binding.hasBooks = false

        return binding.root
    }

    private fun subscribeUi(adapter: BookAdapter,binding: FragmentBookshelfBinding) {
        viewModel.books.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.hasBooks = !it.isNullOrEmpty()
        }
    }
}