package com.example.keerreader.data

class BookRepository private constructor(private val bookDao: BookDao){
    fun getBooks() = bookDao.getBookshelfBooks()

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: BookRepository? = null

        fun getInstance(bookDao: BookDao) =
            instance ?: synchronized(this) {
                instance ?: BookRepository(bookDao).also { instance = it }
            }
    }
}