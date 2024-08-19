package com.vixiloc.vtodo.ui.feature.welcome

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _state = mutableStateOf(WelcomeContract.State())
    val state: State<WelcomeContract.State> = _state

    fun onEvent(event: WelcomeContract.Event) {
        when (event) {
            else -> {

            }
        }
    }
}