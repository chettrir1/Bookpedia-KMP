package com.chettrri.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.chettrri.bookpedia.di.initKoin
import io.ktor.client.engine.okhttp.OkHttp

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Bookpedia-CMP",
    ) {
        App(engine = OkHttp.create())
    }
}