package com.vixiloc.vtodo.di

import com.vixiloc.vtodo.data.dao.TodoDao
import com.vixiloc.vtodo.data.dao.TodoDaoImpl
import org.koin.dsl.module

val daoModule = module {
    factory<TodoDao> {
        TodoDaoImpl(get())
    }
}