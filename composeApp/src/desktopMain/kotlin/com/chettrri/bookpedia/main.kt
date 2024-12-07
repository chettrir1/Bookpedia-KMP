package com.chettrri.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.engine.okhttp.OkHttp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Bookpedia-CMP",
    ) {
        App(engine = OkHttp.create())
    }
}