package com.example.nsak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.nsak.R

class MainActivity3 : AppCompatActivity() {

    private lateinit var questions: Array<String>
    private var currentQuestionIndex = 0
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var rightButton: Button
    private lateinit var leftButton: Button
    private lateinit var questionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        questions = arrayOf(
            getString(R.string.question1),
            getString(R.string.question2),
            getString(R.string.question3),
            getString(R.string.question4),
            getString(R.string.question5),
            getString(R.string.question6),
            getString(R.string.question7),
            getString(R.string.question8),
            getString(R.string.question9),
            getString(R.string.question10)
        )

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        rightButton = findViewById(R.id.rightb)
        leftButton = findViewById(R.id.leftb)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener {
            checkAnswer(true)
            updateQuestion()
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
            updateQuestion()
        }

        rightButton.setOnClickListener {
            updateQuestionIndex(1)
        }

        leftButton.setOnClickListener {
            updateQuestionIndex(-1)
        }

        updateQuestion()
    }

    public fun checkAnswer(isTrue: Boolean) {
        val correctAnswer = getCorrectAnswer()
        val isCorrect = (isTrue && correctAnswer) || (!isTrue && !correctAnswer)
        val messageResId = if (isCorrect) R.string.correct_toast else R.string.incorrect_toast
        val show = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

    private fun getCorrectAnswer(): Boolean {
        val correctAnswers = booleanArrayOf(
            false, // ответ на первый вопрос
            false,  // ответ на второй вопрос
            true, // ответ на третий вопрос
            false,  // ответ на четвертый вопрос
            false,  // ответ на пятый вопрос
            true, // ответ на шестой вопрос
            false,  // ответ на седьмой вопрос
            false,  // ответ на восьмой вопрос
            false, // ответ на девятый вопрос
            false   // ответ на десятый вопрос
        )
        return correctAnswers[currentQuestionIndex]
    }

    private fun updateQuestion() {
        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            questionTextView.text = questions[currentQuestionIndex]
        } else {
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            Toast.makeText(this, "Тест завершен", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateQuestionIndex(increment: Int) {
        currentQuestionIndex += increment
        if (currentQuestionIndex >= questions.size) {
            currentQuestionIndex = 0
        } else if (currentQuestionIndex < 0) {
            currentQuestionIndex = questions.size - 1
        }
        questionTextView.text = questions[currentQuestionIndex]
    }
    private fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

}
