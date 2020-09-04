package com.example.keerreader.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.keerreader.data.BookRepository

class BookshelfViewModelFactory(
    private val repository: BookRepository
) : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")//用于取消warning
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookshelfViewModel(repository) as T
    }


}