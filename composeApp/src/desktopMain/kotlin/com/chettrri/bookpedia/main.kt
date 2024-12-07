package com.chettrri.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.chettrri.bookpedia.app.App
import com.chettrri.bookpedia.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Bookpedia-CMP",
        ) {
            App( )
        }
    }
}