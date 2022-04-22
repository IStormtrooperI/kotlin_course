package ru.example.myapplication.model

import java.io.Serializable

data class QuestionData(
    val question: String,
    var questionAnswers: List<AnswerData>,
    val correctAnswer: AnswerData
):Serializable
