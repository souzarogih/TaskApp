package com.higorsouza.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.higorsouza.taskapp.R
import com.higorsouza.taskapp.databinding.FragmentFormTaskBinding
import com.higorsouza.taskapp.util.initToolbar
import com.higorsouza.taskapp.util.showBottomSheet

class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)

        initListeners()
    }

    private fun initListeners(){
        binding.btnSave.setOnClickListener {
            validateData()
        }
    }

    private fun validateData(){
        val description = binding.edtDescription.text.toString().trim()

        if(description.isNotEmpty()){
            Toast.makeText(requireContext(), "Tudo certo.", Toast.LENGTH_SHORT).show()
        }else{
            showBottomSheet(message = R.string.description_empty_form_task_fragment)
//            Toast.makeText(requireContext(), "Preencha uma descrição.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}