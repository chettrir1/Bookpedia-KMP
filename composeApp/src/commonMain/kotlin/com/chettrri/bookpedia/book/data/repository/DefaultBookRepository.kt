package com.chettrri.bookpedia.book.data.repository

import com.chettrri.bookpedia.book.data.mappers.toBook
import com.chettrri.bookpedia.book.data.network.RemoteBookDataSource
import com.chettrri.bookpedia.book.domain.Book
import com.chettrri.bookpedia.core.domain.DataError
import com.chettrri.bookpedia.core.domain.Result
import com.chettrri.bookpedia.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query).map { dto ->
            dto.results.map {
                it.toBook()
            }
        }
    }
}