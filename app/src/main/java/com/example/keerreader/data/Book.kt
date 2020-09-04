package com.example.keerreader.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookshelf")
data class Book (
    @PrimaryKey val id:String,
    val name:String,
    val sourceFrom:String,
    val bookUrl:String,
    val length:Int,
    val localFilePath:String?,
    val classification:String?,
    val writer:String?,
    val imageUrl:String?
)