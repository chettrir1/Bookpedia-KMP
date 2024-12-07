package com.chettrri.bookpedia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chettrri.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.chettrri.bookpedia.book.data.repository.DefaultBookRepository
import com.chettrri.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.chettrri.bookpedia.book.presentation.book_list.BookListViewModel
import com.chettrri.bookpedia.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel(
            repository = DefaultBookRepository(
                remoteBookDataSource = KtorRemoteBookDataSource(
                    httpClient = HttpClientFactory.create(engine)
                )
            )
        ) },
        onBookCLick = {
        }
    )
}