package com.higorsouza.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.higorsouza.taskapp.R
import com.higorsouza.taskapp.databinding.FragmentRecoveryAccountBinding
import com.higorsouza.taskapp.util.initToolbar
import com.higorsouza.taskapp.util.showBottomSheet

class RecoveryAccountFragment : Fragment() {

    private var _binding: FragmentRecoveryAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoveryAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListeners()
    }

    private fun initListeners(){
        binding.btnRecover.setOnClickListener {
            validateData()
        }
    }

    private fun validateData(){
        val email = binding.edtEmail.text.toString().trim()

        if(email.isNotEmpty()){
            Toast.makeText(requireContext(), "Tudo certo.", Toast.LENGTH_SHORT).show()
        }else{
            showBottomSheet(message = getString(R.string.email_empty))
//            Toast.makeText(requireContext(), "Preencha seu email.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}