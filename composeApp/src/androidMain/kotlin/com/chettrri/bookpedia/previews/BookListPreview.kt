package com.chettrri.bookpedia.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.chettrri.bookpedia.book.presentation.book_list.BookListScreen
import com.chettrri.bookpedia.book.presentation.book_list.BookListState
import com.chettrri.bookpedia.book.presentation.book_list.books

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