package com.chettrri.bookpedia.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.chettrri.bookpedia.book.domain.Book
import com.chettrri.bookpedia.book.presentation.book_list.BookListScreen
import com.chettrri.bookpedia.book.presentation.book_list.BookListState

private val books = (1..100).map {
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

@PreviewLightDark
@Composable
fun BookListScreenPreview(modifier: Modifier = Modifier) {
    BookListScreen(
        state = BookListState(
            searchResults = books
        ),
        onAction = {}

    )
}