package com.chettrri.bookpedia.book.domain

import com.chettrri.bookpedia.core.domain.DataError
import com.chettrri.bookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>

    suspend fun getBookDetails(bookId: String): Result<String?, DataError>
}