package ru.example.myapplication.ui.quiz

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import ru.example.myapplication.databinding.FragmentQuizBinding
import ru.example.myapplication.model.QuestionData
import ru.example.myapplication.objects.QuestionsListObject

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var currentQuestion = 0
    private var currentPoints = 0
    private val questions = getQuestions()

    private fun getQuestions(): List<QuestionData> {
        var questions = QuestionsListObject.questionsList
        questions = questions.shuffled()
        questions.forEachIndexed { index, element ->
            questions[index].questionAnswers = questions[index].questionAnswers.shuffled()
        }
        return questions
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val quizViewModel =
            ViewModelProvider(this).get(QuizViewModel::class.java)

        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("ResourceType")
    private fun checkAnswer(currentAnswer: MaterialButton) {

        currentAnswer.strokeWidth = 3

        if (currentAnswer.text == questions[currentQuestion - 1].correctAnswer.answer) {

            currentAnswer.strokeColor = ColorStateList.valueOf(0xff609933.toInt())
            binding.correctAnswer.visibility = View.VISIBLE
            currentPoints++

            binding.correctAnswer.updateLayoutParams<ConstraintLayout.LayoutParams> {
                topToTop = currentAnswer.id
                endToEnd = currentAnswer.id
            }
        } else {
            currentAnswer.strokeColor = ColorStateList.valueOf(0xffB2273B.toInt())
            binding.yourAnswer.visibility = View.VISIBLE
            binding.correctAnswer.visibility = View.VISIBLE

            binding.yourAnswer.updateLayoutParams<ConstraintLayout.LayoutParams> {
                topToTop = currentAnswer.id
                endToEnd = currentAnswer.id
            }

            var correctAnswer: MaterialButton = binding.firstAnswer

            when {
                binding.secondAnswer.text == questions[currentQuestion - 1].correctAnswer.answer -> {
                    correctAnswer = binding.secondAnswer
                }
                binding.thirdAnswer.text == questions[currentQuestion - 1].correctAnswer.answer -> {
                    correctAnswer = binding.thirdAnswer
                }
                binding.fourthAnswer.text == questions[currentQuestion - 1].correctAnswer.answer -> {
                    correctAnswer = binding.fourthAnswer
                }
            }
            binding.correctAnswer.updateLayoutParams<ConstraintLayout.LayoutParams> {
                topToTop = correctAnswer.id
                endToEnd = correctAnswer.id
            }
        }

        binding.firstAnswer.isEnabled = false
        binding.firstAnswer.isClickable = false

        binding.secondAnswer.isEnabled = false
        binding.secondAnswer.isClickable = false

        binding.thirdAnswer.isEnabled = false
        binding.thirdAnswer.isClickable = false

        binding.fourthAnswer.isEnabled = false
        binding.fourthAnswer.isClickable = false

        binding.nextQuestion.isEnabled = true
        binding.nextQuestion.isClickable = true
        binding.nextQuestion.setTextColor(ColorStateList.valueOf(0xFF000000.toInt()))
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    private fun nextQuestion() {

        binding.correctAnswer.visibility = View.GONE
        binding.yourAnswer.visibility = View.GONE

        currentQuestion++

        if (currentQuestion <= questions.size) {
            binding.statusQuestion.text = "Вопрос ${currentQuestion}/${questions.size}"
            binding.question.text = questions[currentQuestion - 1].question
            binding.firstAnswer.strokeWidth = 0
            binding.firstAnswer.strokeColor = ColorStateList.valueOf(0xff2d2d2d.toInt())
            binding.firstAnswer.text = questions[currentQuestion - 1].questionAnswers[0].answer
            binding.secondAnswer.strokeWidth = 0
            binding.secondAnswer.strokeColor = ColorStateList.valueOf(0xff2d2d2d.toInt())
            binding.secondAnswer.text = questions[currentQuestion - 1].questionAnswers[1].answer
            binding.thirdAnswer.strokeWidth = 0
            binding.thirdAnswer.strokeColor = ColorStateList.valueOf(0xff2d2d2d.toInt())
            binding.thirdAnswer.text = questions[currentQuestion - 1].questionAnswers[2].answer
            binding.fourthAnswer.strokeWidth = 0
            binding.fourthAnswer.strokeColor = ColorStateList.valueOf(0xff2d2d2d.toInt())
            binding.fourthAnswer.text = questions[currentQuestion - 1].questionAnswers[3].answer
            binding.nextQuestion.isEnabled = false
            binding.nextQuestion.isClickable = false
            binding.firstAnswer.isEnabled = true
            binding.firstAnswer.isClickable = true
            binding.secondAnswer.isEnabled = true
            binding.secondAnswer.isClickable = true
            binding.thirdAnswer.isEnabled = true
            binding.thirdAnswer.isClickable = true
            binding.fourthAnswer.isEnabled = true
            binding.fourthAnswer.isClickable = true
            binding.nextQuestion.setTextColor(ColorStateList.valueOf(0x50000000.toInt()))
        } else {
            binding.statusQuestion.visibility = View.GONE
            binding.question.visibility = View.GONE
            binding.firstAnswer.visibility = View.GONE
            binding.secondAnswer.visibility = View.GONE
            binding.thirdAnswer.visibility = View.GONE
            binding.fourthAnswer.visibility = View.GONE
            binding.nextQuestion.visibility = View.GONE

            binding.victoryImage.visibility = View.VISIBLE
            binding.victoryTextFirst.visibility = View.VISIBLE
            binding.victoryTextSecond.visibility = View.VISIBLE
            binding.victoryTextSecond.text =
                "Вы ответили на $currentPoints вопросов из ${questions.size}."
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun setUpUI() {

        binding.startQuiz.setOnClickListener {

            binding.startQuiz.visibility = View.GONE
            binding.startMessage.visibility = View.GONE

            binding.statusQuestion.visibility = View.VISIBLE
            binding.question.visibility = View.VISIBLE
            binding.firstAnswer.visibility = View.VISIBLE
            binding.secondAnswer.visibility = View.VISIBLE
            binding.thirdAnswer.visibility = View.VISIBLE
            binding.fourthAnswer.visibility = View.VISIBLE
            binding.nextQuestion.visibility = View.VISIBLE

            nextQuestion()
        }

        binding.nextQuestion.setOnClickListener {
            nextQuestion()
        }

        binding.firstAnswer.setOnClickListener {
            checkAnswer(binding.firstAnswer)
        }

        binding.secondAnswer.setOnClickListener {
            checkAnswer(binding.secondAnswer)
        }

        binding.thirdAnswer.setOnClickListener {
            checkAnswer(binding.thirdAnswer)
        }

        binding.fourthAnswer.setOnClickListener {
            checkAnswer(binding.fourthAnswer)
        }
    }
}