package com.higorsouza.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.higorsouza.taskapp.R
import com.higorsouza.taskapp.databinding.FragmentLoginBinding
import com.higorsouza.taskapp.databinding.FragmentSplashBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners(){
        binding.btnLogin.setOnClickListener {
            validateData()
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnRecover.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recoveryAccountFragment)
        }
    }

    private fun validateData(){
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if(email.isNotEmpty()){
            if(password.isNotEmpty()){
                findNavController().navigate(R.id.action_global_homeFragment)
            }else{
                Toast.makeText(requireContext(), "Preencha sua senha.", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(), "Preencha seu email.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}