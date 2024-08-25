package com.vixiloc.vtodo.ui.feature.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.vixiloc.vtodo.data.repository.TodoRepository

class HomeViewModel(private val repository: TodoRepository) : ViewModel() {

    private val _state = mutableStateOf(HomeContract.State())
    val state get() = _state as State<HomeContract.State>

    fun onEvent(event: HomeContract.Event) {
        when (event) {
            is HomeContract.Event.Save -> {

            }

            is HomeContract.Event.Edit -> {

            }

            is HomeContract.Event.ChangeInput -> {
                when (event.name) {
                    HomeContract.InputName.TodoName -> {
                        _state.value = state.value.copy(inputTodoName = event.value)
                    }

                    HomeContract.InputName.Search -> {
                        _state.value = state.value.copy(searchValue = event.value)
                    }
                }
            }

            is HomeContract.Event.ShowAddTodo -> {
                _state.value = state.value.copy(showAddTodo = event.show)
            }

            is HomeContract.Event.ShowEditTodo -> {
                _state.value = state.value.copy(showEditTodo = event.show)
            }
        }
    }
}