package com.vixiloc.vtodo.data.repository

import com.vixiloc.vtodo.data.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl : TaskRepository {
    override suspend fun save(data: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun update(data: Task): Task {
        TODO("Not yet implemented")
    }

    override suspend fun delete(data: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun find(taskId: String): Task {
        TODO("Not yet implemented")
    }

    override suspend fun all(): Flow<List<Task>> {
        TODO("Not yet implemented")
    }
}