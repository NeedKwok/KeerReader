package com.example.keerreader.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.keerreader.data.Book
import com.example.keerreader.data.BookRepository


class BookshelfViewModel internal constructor(
    bookRepository: BookRepository
) : ViewModel() {

    val books:LiveData<List<Book>> = bookRepository.getBooks()

}