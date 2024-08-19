package com.vixiloc.vtodo.data.repository

import com.vixiloc.vtodo.data.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl : TodoRepository {
    override suspend fun save(data: Todo) {
        TODO("Not yet implemented")
    }

    override suspend fun update(data: Todo): Todo {
        TODO("Not yet implemented")
    }

    override suspend fun delete(data: Todo) {
        TODO("Not yet implemented")
    }

    override suspend fun find(todoId: String): Todo {
        TODO("Not yet implemented")
    }

    override suspend fun all(): Flow<List<Todo>> {
        TODO("Not yet implemented")
    }
}