package com.peculiaruc.alc_mmsystem_mentor.data.local.models.util

import android.content.Context
import com.peculiaruc.alc_mmsystem_mentor.R
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.Task

/**
 * A [TaskList] utility class.
 *
 * It holds details of Tasks.
 * @property tasks List of tasks
 */
class TaskList(context: Context) {
    var tasks: ArrayList<Task> = arrayListOf()

    private val taskOne = Task(
        1,
        context.getString(R.string.document_auth),
        context.getString(R.string.lorem_2),
        assigned = false,
        completed = false,
        assignee = 0
    )
    private val taskTwo = Task(
        2,
        context.getString(R.string.implement_di),
        context.getString(R.string.lorem_2),
        assigned = true,
        completed = false,
        assignee = 3
    )
    private val taskThree = Task(
        3,
        context.getString(R.string.fetch_api),
        context.getString(R.string.lorem_2),
        assigned = false,
        completed = true,
        assignee = 4
    )
    private val taskFour = Task(
        4,
        context.getString(R.string.local_caching),
        context.getString(R.string.lorem_2),
        true,
        false,
        3
    )
    private val taskFive = Task(
        5,
        context.getString(R.string.create_db),
        context.getString(R.string.lorem_2),
        assigned = false,
        completed = false,
        assignee = 5
    )
    private val taskSix = Task(
        6,
        context.getString(R.string.implent_nav),
        context.getString(R.string.lorem_2),
        assigned = false,
        completed = true,
        assignee = 5
    )
    private val taskSeven = Task(
        7,
        context.getString(R.string.settings_endpoints),
        context.getString(R.string.lorem_2),
        assigned = false,
        completed = false,
        assignee = 1
    )
    private val taskEight = Task(
        8,
        context.getString(R.string.implement_firestore),
        context.getString(R.string.lorem_2),
        assigned = true,
        completed = false,
        assignee = 3
    )
    private val taskNine = Task(
        9,
        context.getString(R.string.implement_ui),
        context.getString(R.string.lorem_2),
        assigned = true,
        completed = false,
        assignee = 3
    )
    private val taskTen = Task(
        10,
        context.getString(R.string.implement_i8n),
        context.getString(R.string.lorem_2),
        assigned = false,
        completed = true,
        assignee = 4
    )
    init {
        tasks.addAll(listOf(taskOne, taskTwo, taskThree, taskFour, taskFive,taskSix, taskSeven,
            taskEight, taskNine, taskTen))
    }

     fun getAllTasks(): ArrayList<Task>{
        return tasks
    }

    fun getSpecificTask(idx: Int): Task{
        if (tasks.isEmpty()){
            return tasks[0]
        }
        return tasks[idx]
    }


}