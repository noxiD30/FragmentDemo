package com.example.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.fragmentdemo.databinding.FragmentGameBinding
import com.example.fragmentdemo.databinding.FragmentWlcBinding

class GameFragment : Fragment() {

    lateinit var binding: FragmentGameBinding
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>

    var questionIndex = 0
    var score :Int=0
    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "Which Order have been implemented by Malaysia government to prevent COVID-19?",
            answers = listOf("Movement Control Order", "Multiple Choice Order", "More Coffee Order " )
        ),
        Question(
            text = "What is FMCO?",
            answers = listOf("Full Movement Control Oder",  "Fun Movement Control Oder", "Forever Movement Control Oder")
        )
    )
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()

        answers.shuffle()

        binding.txtViewQuestion.text = currentQuestion.text
        binding.radioA.text = answers[0]
        binding.radioB.text = answers[1]
        binding.radioC.text = answers[2]

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        setQuestion()
binding.btnNext.setOnClickListener(){
    val checkedId = binding.radioGroup.checkedRadioButtonId

    if (checkedId != -1) {
        var answerIndex = 0


        when (checkedId) {
            R.id.radio_A -> answerIndex = 0
            R.id.radio_B -> answerIndex = 1
            R.id.radio_C -> answerIndex = 2
        }
        if (answers[answerIndex] == currentQuestion.answers[0]) {
            score += 1
        }
        if (questionIndex < 1) {
            questionIndex += 1
            binding.radioGroup.clearCheck()
            setQuestion()

        } else {
            Navigation.findNavController(it).navigate(R.id.action_gameFragment_to_lastFragment)
        }
    }else{
        Toast.makeText(context, "please select answer", Toast.LENGTH_LONG).show()
    }
}
        return binding.root
    }

}