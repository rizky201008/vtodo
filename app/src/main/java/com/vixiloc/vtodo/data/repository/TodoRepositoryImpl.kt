package com.vixiloc.vtodo.data.repository

import com.vixiloc.vtodo.data.dao.TodoDao
import com.vixiloc.vtodo.data.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(private val dao: TodoDao) : TodoRepository {
    override suspend fun createTodo(data: Todo): Todo {
        dao.save(data)

        return dao.findLastInserted()
    }

    override suspend fun updateTodo(data: Todo): Todo {
        dao.update(data)

        return dao.find(data._id.toString())
    }

    override suspend fun deleteTodo(data: Todo) {
        dao.delete(data)
    }

    override suspend fun findTodo(todoId: String): Todo {
        return dao.find(todoId)
    }

    override suspend fun allTodo(): Flow<List<Todo>> {
        return dao.all()
    }
}