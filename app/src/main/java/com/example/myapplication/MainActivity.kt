package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionView: TextView


    private val questionBank = listOf(
        Question(R.string.question_Australia,true),
        Question(R.string.question_Ocean,true),
        Question(R.string.question_Mideast,false),
        Question(R.string.question_Africa,false),
        Question(R.string.question_America,true),
        Question(R.string.question_Asia,true)
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = false_button
        nextButton = findViewById(R.id.next_button)
        questionView = findViewById(R.id.question_text_view)




        question_text_view.setOnClickListener{
            index = (index+1)%questionBank.size
            updateQuestion()
        }

        trueButton.setOnClickListener {
            val ans = checkAnswer(true)
            Toast.makeText(this, ans, Toast.LENGTH_SHORT).show()


        }

        falseButton.setOnClickListener {
            val ans = checkAnswer(false)
            Toast.makeText(this, ans, Toast.LENGTH_SHORT).show()

        }
        nextButton.setOnClickListener{
            index = (index+1)%questionBank.size
            updateQuestion()
        }

        previous_Button.setOnClickListener {
            index = (index-1)%questionBank.size
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion(){
        val questionResId = questionBank[index].textResId
        question_text_view.setText(questionResId)
    }

    private fun checkAnswer(userAnswer: Boolean): Int{
        val correctAnswer = questionBank[index].answer
        val messageId = if (userAnswer == correctAnswer){
            R.string.correct_toast
        }
        else{
            R.string.incorrect_toast
        }
        return messageId
    }




}
