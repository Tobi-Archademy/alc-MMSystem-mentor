package com.peculiaruc.alc_mmsystem_mentor.data.local.dao

import androidx.room.*
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.Task
import kotlinx.coroutines.flow.Flow

/**
 * TaskDao [TaskDao] interface
 *
 * Defines access methods and queries for room database
 * @author Eric Ibu
 */
@Dao
interface TaskDao {

    //Get all tasks
    @Query("SELECT * from task")
    fun getTasks() : Flow<List<Task>>

    //add a task
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: Task)

    //update a task
    @Update
    suspend fun updateTask(task: Task)

    //delete a tasks
    @Delete
    suspend fun deleteTask(task: Task)


}