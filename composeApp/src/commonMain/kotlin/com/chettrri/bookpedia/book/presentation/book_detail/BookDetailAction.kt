package com.chettrri.bookpedia.book.presentation.book_detail

import com.chettrri.bookpedia.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClicked : BookDetailAction
    data object OnFavoriteClicked : BookDetailAction
    data class OnSelectedBookChange(val book: Book) : BookDetailAction
}