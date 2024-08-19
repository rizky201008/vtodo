package com.vixiloc.vtodo.ui.feature.welcome

class WelcomeContract {

    sealed class Event {

    }

    data class State(
        val a: String = ""
    )
}