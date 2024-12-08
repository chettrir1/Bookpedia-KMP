package com.chettrri.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable(with = BookDescriptionDtoSerializer::class)
data class BookDescriptionDto(
    val description: String? = null
)
