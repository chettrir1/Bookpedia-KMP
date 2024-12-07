@file:OptIn(FlowPreview::class)

package com.chettrri.bookpedia.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.chettrri.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.chettrri.bookpedia.book.data.network.RemoteBookDataSource
import com.chettrri.bookpedia.book.data.repository.DefaultBookRepository
import com.chettrri.bookpedia.book.domain.BookRepository
import com.chettrri.bookpedia.book.presentation.SelectedBookViewModel
import com.chettrri.bookpedia.book.presentation.book_list.BookListViewModel
import com.chettrri.bookpedia.core.data.HttpClientFactory
import kotlinx.coroutines.FlowPreview
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

//works for all the platform
val sharedModule = module {
    single {
        HttpClientFactory.create(get())
    }

    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)

}