package com.peculiaruc.alc_mmsystem_mentor.ui.tasks.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentor.R
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.Task
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.util.TaskList
import com.peculiaruc.alc_mmsystem_mentor.databinding.FragmentTaskDetailBinding

/**
 * A [TaskDetailFragment] fragment.
 *
 * It displays details of Tasks.
 * @property tasks List of tasks
 * @property binding view binding property
 */

class TaskDetailFragment : Fragment() {

    var tasks: ArrayList<Task> = arrayListOf()
    private var _binding: FragmentTaskDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTaskDetailBinding.inflate(inflater, container, false)

        val back = binding.imageView
        back.setOnClickListener {
            it.findNavController().navigateUp()
        }
        val allTasks = TaskList(requireContext()).getAllTasks()
        tasks.addAll(allTasks)
            return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val argsId = arguments?.getInt("id")?.minus(1)

        binding.textView4.text = tasks[argsId!!].title
        binding.textView5.text = tasks[argsId].desc
        val bundle = Bundle()
        bundle.putInt("id", argsId)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_taskDetailFragment_to_taskAssignedFragment, bundle)
        }
    }
}