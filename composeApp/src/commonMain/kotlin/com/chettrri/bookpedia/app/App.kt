@file:OptIn(FlowPreview::class)

package com.chettrri.bookpedia.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.chettrri.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.chettrri.bookpedia.book.presentation.book_list.BookListViewModel
import kotlinx.coroutines.FlowPreview
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.BookGraph
        ) {
            navigation<Routes.BookGraph>(
                startDestination = Routes.BookList
            ) {
                composable<Routes.BookList> {
                    val viewModel = koinViewModel<BookListViewModel>()
                    BookListScreenRoot(
                        viewModel = viewModel,
                        onBookCLick = { book ->
                            navController.navigate(
                                Routes.BookDetail(book.id)
                            )
                        }
                    )
                }
                composable<Routes.BookDetail> { entry ->
                    val args = entry.toRoute<Routes.BookDetail>()
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "Book Detail ${args.bookId}")
                    }
                }
            }

        }
    }
}