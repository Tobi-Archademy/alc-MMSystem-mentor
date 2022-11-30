package com.peculiaruc.alc_mmsystem_mentor.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Task [Task] data class
 *
 * This class provides setter, getter and describes our task object.
 *
 * @param id unique identifier for each individual task.
 * @param title the title of the task
 * @param desc the description of the task
 * @param assigned is this task assigned?
 * @param completed is the task completed?
 * @param assignee the id of the mentor the task is assigned to.
 * @constructor Creates a task object.
 */

@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "description")
    var desc: String,
    @ColumnInfo(name = "assigned")
    val assigned: Boolean,
    @ColumnInfo(name = "completed")
    val completed: Boolean,
    @ColumnInfo(name = "assignee")
    val assignee: Int
)
