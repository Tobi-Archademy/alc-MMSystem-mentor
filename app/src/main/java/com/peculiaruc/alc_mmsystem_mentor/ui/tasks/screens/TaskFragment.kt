package com.peculiaruc.alc_mmsystem_mentor.ui.tasks.screens

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.Task
import com.peculiaruc.alc_mmsystem_mentor.data.local.models.util.TaskList
import com.peculiaruc.alc_mmsystem_mentor.databinding.FragmentTaskBinding
import com.peculiaruc.alc_mmsystem_mentor.ui.tasks.adapters.TaskListAdapter
import java.util.*

/**
 * Task Fragment Class
 */

class TaskFragment : Fragment() {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var viewPager: ViewPager2
    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TaskListAdapter

    var tasks: ArrayList<Task> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTaskBinding.inflate(inflater, container, false)

        _binding!!.apply {
            search.setOnSearchClickListener {
                imageView2.visibility = View.INVISIBLE
                search.visibility = View.VISIBLE
            }
            imageView.setOnClickListener {
                    it.findNavController().navigateUp()
                imageView.visibility = View.VISIBLE
                imageView2.visibility = View.VISIBLE
                search.visibility = View.INVISIBLE
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        taskAdapter = TaskAdapter(this)
        viewPager = binding.pager
        viewPager.adapter = taskAdapter

        val allTasks = TaskList(requireContext()).getAllTasks()
        tasks.addAll(allTasks)
        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "All"
                1 -> tab.text = "Assigned"
                2 -> tab.text = "Complete"
                3 -> tab.text = "My Tasks"
            }
        }.attach()
    }
    // calling on create option menu
    // layout to inflate our menu file.
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        // below line is to call set on query text listener method.
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText)
                return false
            }
        })
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist = ArrayList<Task>()

        // running a for loop to compare elements.
        for (item in tasks) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.title.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist)
        }
    }
}


private const val ARG_OBJECT = "object"

class TaskAdapter(taskFragment: TaskFragment) : FragmentStateAdapter(taskFragment) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): TaskObjectFragment {
        var fragment = TaskObjectFragment(position)
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(ARG_OBJECT, position)
        }
        return fragment
    }


}
