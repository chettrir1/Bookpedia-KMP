@file:OptIn(FlowPreview::class)

package com.chettrri.bookpedia

import androidx.compose.runtime.Composable
import com.chettrri.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.chettrri.bookpedia.book.presentation.book_list.BookListViewModel
import kotlinx.coroutines.FlowPreview
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<BookListViewModel>()
    BookListScreenRoot(
        viewModel = viewModel,
        onBookCLick = {
        }
    )
}