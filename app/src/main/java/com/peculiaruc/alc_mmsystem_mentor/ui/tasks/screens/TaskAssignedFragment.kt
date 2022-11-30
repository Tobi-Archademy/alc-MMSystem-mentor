package com.peculiaruc.alc_mmsystem_mentor.ui.tasks.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentor.R
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.Task
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.util.TaskList

/**
 * A Fragment [TaskAssignedFragment] class.
 *
 * @property tasks
 */

class TaskAssignedFragment : Fragment() {

    var tasks: ArrayList<Task> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val allTasks = TaskList(requireContext()).getAllTasks()
        tasks.addAll(allTasks)
        val view = inflater.inflate(R.layout.fragment_task_assigned, container, false)
        val btn = view.findViewById<Button>(R.id.button2)
        val textViewTitle = view.findViewById<TextView>(R.id.textView4)
        val textViewDesc= view.findViewById<TextView>(R.id.textView5)

        val id = arguments?.getInt("id")
            textViewTitle.text = tasks[id!!].title
            textViewDesc.text = tasks[id].desc

        btn.setOnClickListener {
            findNavController().navigate(R.id.action_taskAssignedFragment_to_taskFragment)
        }
        val back = view.findViewById<ImageView>(R.id.imageView)
        back.setOnClickListener {
            it.findNavController().navigateUp()
        }

        return view

    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) = TaskAssignedFragment().apply {
            val fragment = TaskAssignedFragment()
            val args = Bundle().apply {
                putInt("id", position)
            }
            fragment.arguments = args
            return fragment
        }
    }
}