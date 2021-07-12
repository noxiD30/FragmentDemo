package com.example.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.fragmentdemo.databinding.FragmentWlcBinding


class WlcFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentWlcBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_wlc, container, false)

        binding.btnLogin.setOnClickListener() {
            Navigation.findNavController(it).navigate(R.id.action_wlcFragment_to_gameFragment)
        }

        return binding.root
    }


}