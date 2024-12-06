package com.chettrri.bookpedia.book.data.mappers

import com.chettrri.bookpedia.book.data.dto.SearchBookDto
import com.chettrri.bookpedia.book.domain.Book

fun SearchBookDto.toBook(): Book {
    return Book(
        id = id,
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