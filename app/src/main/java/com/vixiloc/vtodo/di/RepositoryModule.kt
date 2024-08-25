package com.vixiloc.vtodo.di

import com.vixiloc.vtodo.data.repository.TodoRepository
import com.vixiloc.vtodo.data.repository.TodoRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<TodoRepository> { TodoRepositoryImpl(get()) }
}