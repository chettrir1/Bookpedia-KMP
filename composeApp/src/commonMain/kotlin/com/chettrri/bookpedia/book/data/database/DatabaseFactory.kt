package com.chettrri.bookpedia.book.data.database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<FavoriteBookDatabase> {

    }
}