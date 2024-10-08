package com.vixiloc.vtodo.ui.feature.home

import androidx.compose.ui.text.input.TextFieldValue
import com.vixiloc.vtodo.data.model.Todo

class HomeContract {

    sealed class Event {
        data object Save : Event()
        data object Edit : Event()
        data class ChangeInput(val name: InputName, val value: TextFieldValue) : Event()
        data class ShowAddTodo(val show: Boolean) : Event()
        data class ShowEditTodo(val show: Boolean,val todo: Todo?) : Event()
        data class ChangeTodoStatus(val todo: Todo) : Event()
        data class DeleteTodo(val todo: Todo) : Event()
        data object ClearInputs : Event()
    }

    enum class InputName {
        Search,
        TodoName
    }

    data class State(
        val todos: List<Todo> = emptyList(),
        val showAddTodo: Boolean = false,
        val showEditTodo: Boolean = false,
        val selectedTodo: Todo? = null,
        val searchValue: TextFieldValue = TextFieldValue(),
        val inputTodoName: TextFieldValue = TextFieldValue(),
    )
}