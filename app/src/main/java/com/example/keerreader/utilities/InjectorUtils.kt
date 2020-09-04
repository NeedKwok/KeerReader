package com.example.keerreader.utilities

import android.content.Context
import com.example.keerreader.data.AppDatabase
import com.example.keerreader.data.BookRepository
import com.example.keerreader.viewmodel.BookshelfViewModelFactory

object InjectorUtils {
     private fun getBookRepository(context: Context): BookRepository {
        return BookRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).bookDao())
    }

    fun provideBookshelfViewModelFactory(
        context: Context
    ): BookshelfViewModelFactory {
        return BookshelfViewModelFactory(getBookRepository(context))
    }
}