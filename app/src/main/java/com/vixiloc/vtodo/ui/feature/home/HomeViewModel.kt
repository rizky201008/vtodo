package com.vixiloc.vtodo.ui.feature.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixiloc.vtodo.data.model.Todo
import com.vixiloc.vtodo.data.repository.TodoRepository
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class HomeViewModel : ViewModel() {
    private val repository: TodoRepository by inject(TodoRepository::class.java)
    private val _state = mutableStateOf(HomeContract.State())
    val state get() = _state as State<HomeContract.State>

    fun onEvent(event: HomeContract.Event) {
        when (event) {
            is HomeContract.Event.Save -> {
                viewModelScope.launch {
                    saveTodo()
                }
            }

            is HomeContract.Event.Edit -> {
                viewModelScope.launch {
//                    updateTodo()
                }
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

            is HomeContract.Event.ChangeTodoStatus -> {
                val todo = Todo().apply {
                    _id = event.todo._id
                    completed = !event.todo.completed
                    name = event.todo.name
                }
                viewModelScope.launch {
                    updateTodo(todo)
                }
            }

            is HomeContract.Event.ClearInputs -> {
                clearInputs()
            }
        }
    }

    private suspend fun updateTodo(todo: Todo) {
        val newTodo = repository.updateTodo(todo)
        clearInputs()
    }

    private suspend fun saveTodo() {
        val todo = Todo().apply {
            name = state.value.inputTodoName.text
        }

        repository.createTodo(todo)
        clearInputs()
    }

    private fun clearInputs() {
        _state.value = state.value.copy(inputTodoName = TextFieldValue())
    }

    private suspend fun getTodos() {
        repository.allTodo().collect { todos ->
            _state.value = state.value.copy(todos = todos)
        }
    }

    init {
        viewModelScope.launch {
            getTodos()
        }
    }
}