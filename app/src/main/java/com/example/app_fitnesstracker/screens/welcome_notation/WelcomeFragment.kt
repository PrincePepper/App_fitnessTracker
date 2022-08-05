package com.example.app_fitnesstracker.screens.welcome_notation

import android.os.Bundle
import com.example.app_fitnesstracker.R
import com.example.app_fitnesstracker.databinding.FragmentWelcomeBinding
import com.example.app_fitnesstracker.screens.BaseFragment


class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(R.layout.fragment_welcome) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding.buttonReg.setOnClickListener {
////            findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
//        }
//        binding.textViewBtnLogin.setOnClickListener {
////            findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
//        }
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_welcome, container, false)
//    }

}