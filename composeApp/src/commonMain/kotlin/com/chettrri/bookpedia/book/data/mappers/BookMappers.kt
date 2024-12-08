package com.chettrri.bookpedia.book.data.mappers

import com.chettrri.bookpedia.book.data.database.BookEntity
import com.chettrri.bookpedia.book.data.dto.SearchBookDto
import com.chettrri.bookpedia.book.domain.Book

//mapper to map api dto to domain model
fun SearchBookDto.toBook(): Book {
    return Book(
        id = id.substringAfterLast("/"),
        title = title,
        imageUrl = if (coverKey != null) {
            "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
        } else {
            "https://covers.openlibrary.org/b/id/${coverAlternativeKey}-L.jpg"
        },
        authors = authorNames ?: emptyList(),
        description = null,
        languages = languages ?: emptyList(),
        firstPublishYear = firstPublishYer?.toString(),
        averageRating = ratingsAverage,
        ratingCount = ratingsCount,
        numPages = numberOfPagesMedian,
        numEditions = numberOfEditions ?: 0
    )
}

//mapper to map domain model to entity
fun Book.toBookEntity(): BookEntity {
    return BookEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishYear = firstPublishYear,
        ratingsAverage = averageRating,
        ratingsCount = ratingCount,
        numberOfPagesMedian = numPages,
        editionCount = numEditions
    )
}