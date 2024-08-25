package com.vixiloc.vtodo.data.dao

import com.vixiloc.vtodo.data.model.Todo
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoDaoImpl(private val realm: Realm) : TodoDao {
    override suspend fun save(data: Todo) {
        realm.write {
            this.copyToRealm(data)
        }
    }

    override suspend fun update(data: Todo): Todo {
        realm.write {
            val todo = this.query<Todo>("_id == $0", data._id).find().first()
            todo.name = data.name
            todo.completed = data.completed
        }

        return data
    }

    override suspend fun delete(data: Todo) {
        realm.write {
            val todo = this.query<Todo>("_id == $0", data._id).find().first()
            delete(todo)
        }
    }

    override suspend fun find(todoId: String): Todo {
        val todo = realm.query<Todo>("_id == $0", todoId).find().first()

        return todo
    }

    override suspend fun all(): Flow<List<Todo>> {
        val todos = realm.query<Todo>().find()
        return todos.asFlow().map { it.list }
    }

    override suspend fun findLastInserted(): Todo {
        val todo = realm.query<Todo>().find().last()

        return todo
    }
}