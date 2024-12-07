package com.chettrri.bookpedia.book.presentation.book_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chettrri.bookpedia.book.presentation.book_detail.components.BlurredImageBackground

@Composable
fun BookDetailScreenRoot(
    viewModel: BookDetailViewModel,
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    BookDetailScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is BookDetailAction.OnBackClicked -> onBackClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun BookDetailScreen(state: BookDetailState, onAction: (BookDetailAction) -> Unit) {
    BlurredImageBackground(
        imageUrl = state.book?.imageUrl,
        isFavorite = state.isFavorite,
        onFavoriteClick = {
            onAction(BookDetailAction.OnFavoriteClicked)
        },
        onBackClick = {
            onAction(BookDetailAction.OnBackClicked)
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = state.book?.title?:""
        )
    }
}
