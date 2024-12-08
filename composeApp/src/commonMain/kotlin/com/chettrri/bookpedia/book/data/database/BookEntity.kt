package com.chettrri.bookpedia.book.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: String,
    val title: String,
    val description: String?,
    val imageUrl: String?,
    val languages: List<String>,
    val authors: List<String>,
    val firstPublishYear: String?,
    val ratingsAverage: Double?,
    val ratingsCount: Int?,
    val numberOfPagesMedian: Int?,
    val editionCount: Int,
)
