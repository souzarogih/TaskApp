package com.higorsouza.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.higorsouza.taskapp.R
import com.higorsouza.taskapp.data.model.Status
import com.higorsouza.taskapp.data.model.Task
import com.higorsouza.taskapp.databinding.FragmentDoneBinding
import com.higorsouza.taskapp.databinding.FragmentHomeBinding
import com.higorsouza.taskapp.ui.adapter.TaskAdapter


class DoneFragment : Fragment() {

    private var _binding: FragmentDoneBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(getTasks())
    }

    private fun initRecyclerView(taskList: List<Task>) {
        taskAdapter = TaskAdapter(requireContext(),taskList){task, option ->
            optionSelected(task, option)
        }

        binding.rvTasks.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTasks.setHasFixedSize(true)
        binding.rvTasks.adapter = taskAdapter
    }

    private fun optionSelected(task: Task, option: Int){
        when(option){
            TaskAdapter.SELECT_BACK -> {
                //colocar logs para enviar para salvar no banco e enviar para api
                Toast.makeText(requireContext(), "Back ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_REMOVE -> {
                //colocar logs para enviar para salvar no banco e enviar para api
                Toast.makeText(requireContext(), "Removendo ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_EDIT -> {
                //colocar logs para enviar para salvar no banco e enviar para api
                Toast.makeText(requireContext(), "Editando ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_DETAILS -> {
                //colocar logs para enviar para salvar no banco e enviar para api
                Toast.makeText(requireContext(), "Detalhes ${task.description}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getTasks() = listOf(
        Task("0", "Criar adapter de contatos", Status.DONE),
        Task("1", "Criar dialog padrão para o app", Status.DONE),
        Task("2", "Refatorar código da classe de tarefa", Status.DONE),
        Task("3", "Estudar threads", Status.DONE)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}