package com.example.keerreader.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookDao {
    @Query("SELECT * FROM bookshelf")
    fun getBookshelfBooks(): LiveData<List<Book>>

    @Insert
    suspend fun insertBookToBookshelf(insertBook: Book):Long //返回值是新插入书籍的id

    @Delete
    suspend fun deleteBookFromBookshelf(deleteBook: Book)
}