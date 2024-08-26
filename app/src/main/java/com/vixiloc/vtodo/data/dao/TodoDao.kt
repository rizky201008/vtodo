package com.vixiloc.vtodo.data.dao

import com.vixiloc.vtodo.data.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoDao {
    suspend fun save(data: Todo)
    suspend fun update(data: Todo): Todo
    suspend fun delete(data: Todo)
    suspend fun find(todoId: String): Todo
    suspend fun all(): Flow<List<Todo>>
    suspend fun findLastInserted(): Todo
    suspend fun search(query: String): Flow<List<Todo>>
}