package com.higorsouza.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.higorsouza.taskapp.R
import com.higorsouza.taskapp.data.model.Status
import com.higorsouza.taskapp.data.model.Task
import com.higorsouza.taskapp.databinding.FragmentDoingBinding
import com.higorsouza.taskapp.databinding.FragmentHomeBinding
import com.higorsouza.taskapp.ui.adapter.TaskAdapter


class DoingFragment : Fragment() {

    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(getTasks())
    }

    private fun initRecyclerView(taskList: List<Task>) {
        taskAdapter = TaskAdapter(taskList)

        binding.rvTasks.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTasks.setHasFixedSize(true)
        binding.rvTasks.adapter = taskAdapter
    }

    private fun getTasks() = listOf(
        Task("0", "Validar informações na tela de cadastro", Status.DOING),
        Task("1", "Salvar foto do usuario no banco de dados", Status.DOING),
        Task("2", "Ajustar tela de produtos do app", Status.DOING),
        Task("3", "Criar opção para upload de imagem", Status.DOING),
        Task("4", "Permitir remover os produtos", Status.DOING)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}