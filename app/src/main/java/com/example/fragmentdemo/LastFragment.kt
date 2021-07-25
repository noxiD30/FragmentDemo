package com.example.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class LastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_last, container, false)

        val tv : TextView = view .findViewById(R.id.tv_Score)
        val argument = LastFragmentArgs.fromBundle(requireArguments())
        tv.text = argument.score.toString() + " Question Correct!"

        return view
    }


}