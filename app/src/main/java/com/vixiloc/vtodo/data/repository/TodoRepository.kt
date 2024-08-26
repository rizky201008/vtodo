package com.vixiloc.vtodo.data.repository

import com.vixiloc.vtodo.data.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun createTodo(data: Todo): Todo
    suspend fun updateTodo(data: Todo): Todo
    suspend fun deleteTodo(data: Todo)
    suspend fun findTodo(todoId: String): Todo
    suspend fun allTodo(): Flow<List<Todo>>
    suspend fun searchTodos(query: String): Flow<List<Todo>>
}