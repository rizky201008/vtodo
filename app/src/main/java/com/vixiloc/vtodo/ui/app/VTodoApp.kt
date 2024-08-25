package com.vixiloc.vtodo.ui.app

import android.app.Application
import com.vixiloc.vtodo.di.daoModule
import com.vixiloc.vtodo.di.realmModule
import com.vixiloc.vtodo.di.repositoryModule
import com.vixiloc.vtodo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VTodoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VTodoApp)
            modules(listOf(realmModule, daoModule, repositoryModule, viewModelModule))
        }
    }
}