package com.chettrri.bookpedia.book.presentation.book_list

import com.chettrri.bookpedia.book.domain.Book
import com.chettrri.bookpedia.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = books,
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "https://picsum.photos/200/300?random=$it",
        authors = listOf("Raju Dada"),
        averageRating = it.toDouble(),
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        ratingCount = 1000,
        numPages = 100,
        numEditions = 3
    )
}