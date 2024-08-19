package com.vixiloc.vtodo.data.repository

import com.vixiloc.vtodo.data.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun save(data: Task)
    suspend fun update(data: Task): Task
    suspend fun delete(data: Task)
    suspend fun find(taskId: String): Task
    suspend fun all(): Flow<List<Task>>
}