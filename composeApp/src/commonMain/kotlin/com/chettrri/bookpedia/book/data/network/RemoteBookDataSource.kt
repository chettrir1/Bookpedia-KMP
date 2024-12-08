package com.chettrri.bookpedia.book.data.network

import com.chettrri.bookpedia.book.data.dto.BookDescriptionDto
import com.chettrri.bookpedia.book.data.dto.SearchBookResponseDto
import com.chettrri.bookpedia.core.domain.DataError
import com.chettrri.bookpedia.core.domain.Result

interface RemoteBookDataSource {

    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchBookResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWordId: String): Result<BookDescriptionDto, DataError.Remote>
}