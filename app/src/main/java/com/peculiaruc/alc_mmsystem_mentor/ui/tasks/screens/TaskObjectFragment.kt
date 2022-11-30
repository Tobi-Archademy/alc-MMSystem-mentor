package com.peculiaruc.alc_mmsystem_mentor.ui.tasks.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentor.R
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.Task
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.util.TaskList
import com.peculiaruc.alc_mmsystem_mentor.ui.tasks.adapters.TaskListAdapter

/**
 * A [TaskObjectFragment] fragment.
 *
 * It displays recycler view of all Tasks.
 *
 * @property pos current position in the list
 */
class TaskObjectFragment(position: Int) : Fragment() {

    val pos: Int = position
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskListAdapter

    var tasks: ArrayList<Task> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_task_object, container, false)
        val allTasks = TaskList(requireContext()).getAllTasks()
        tasks.addAll(allTasks)
        recyclerView = view.findViewById<RecyclerView>(R.id.recycle)
        adapter = TaskListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val taskList = TaskList(requireContext())
        when (pos) {
            0 -> {
                tasks.addAll(taskList.getAllTasks())
                adapter.submitList(tasks)
            }
            1 -> {
                tasks.add(taskList.getSpecificTask(1))
                tasks.add(taskList.getSpecificTask(3))
                tasks.add(taskList.getSpecificTask(7))
                tasks.add(taskList.getSpecificTask(8))
                adapter.submitList(tasks)
            }
            2 -> {
                tasks.add(taskList.getSpecificTask(2))
                tasks.add(taskList.getSpecificTask(5))
                tasks.add(taskList.getSpecificTask(6))
                tasks.add(taskList.getSpecificTask(7))
                tasks.add(taskList.getSpecificTask(9))
                adapter.submitList(tasks)
            }
            3 -> {
                tasks.add(taskList.getSpecificTask(1))
                tasks.add(taskList.getSpecificTask(3))
                tasks.add(taskList.getSpecificTask(5))
                tasks.add(taskList.getSpecificTask(8))
                tasks.add(taskList.getSpecificTask(0))
                adapter.submitList(tasks)
            }
        }
    }
}
