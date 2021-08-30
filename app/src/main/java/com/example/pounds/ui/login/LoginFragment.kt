package com.example.pounds.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pounds.databinding.LoginFragmentBinding
import com.example.pounds.viewModels.LoginViewModel

class LoginFragment : Fragment() {



    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= LoginFragmentBinding.inflate(inflater)
        init()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.loginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToAlbumsFragment())
        }



    }
    private fun init(){
        val activity = requireNotNull(this.activity){}
        viewModel = ViewModelProvider(this,
            LoginViewModel.Factory(activity.application)
        ).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner=this
    }


}