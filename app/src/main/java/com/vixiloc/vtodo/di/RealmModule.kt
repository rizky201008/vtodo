package com.vixiloc.vtodo.di

import com.vixiloc.vtodo.data.model.Todo
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.dsl.module

val realmModule = module {
    single { provideRealm() }
}

fun provideRealm(): Realm {
    val config = RealmConfiguration.Builder(
        schema = setOf(
            Todo::class
        )
    )
        .initialData {
            copyToRealm(Todo().apply { name = "First todo" })
        }
        .deleteRealmIfMigrationNeeded()
        .compactOnLaunch()
        .build()

    return Realm.open(config)
}