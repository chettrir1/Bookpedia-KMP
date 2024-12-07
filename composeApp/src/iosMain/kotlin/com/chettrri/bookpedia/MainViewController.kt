package com.chettrri.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import com.chettrri.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) {
    App()
}