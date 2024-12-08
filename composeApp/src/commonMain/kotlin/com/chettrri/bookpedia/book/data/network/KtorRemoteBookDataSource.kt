package com.chettrri.bookpedia.book.data.network

import com.chettrri.bookpedia.book.data.dto.BookDescriptionDto
import com.chettrri.bookpedia.book.data.dto.SearchBookResponseDto
import com.chettrri.bookpedia.core.data.safeCall
import com.chettrri.bookpedia.core.domain.DataError
import com.chettrri.bookpedia.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private const val BASE_URL = "https://openlibrary.org"

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
) : RemoteBookDataSource {

    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?
    ): Result<SearchBookResponseDto, DataError.Remote> {
        return safeCall<SearchBookResponseDto> {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                resultLimit?.let { parameter("limit", it) }
                parameter("language", "eng")
                parameter(
                    "fields",
                    "key,title,language,cover_i,author_key,author_name,cover_edition_key,first_publish_year,ratings_average,ratings_count,number_of_pages_median,edition_count"
                )
            }
        }
    }

    override suspend fun getBookDetails(bookWordId: String): Result<BookDescriptionDto, DataError.Remote> {
        return safeCall<BookDescriptionDto> {
            httpClient.get(
                urlString = "$BASE_URL/works/$bookWordId.json"
            )
        }
    }
}