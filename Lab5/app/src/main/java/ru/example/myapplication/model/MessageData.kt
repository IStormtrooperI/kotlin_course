package ru.example.myapplication.model

import java.io.Serializable

data class MessageData (
    val message: String,
    val fullName: String
): Serializable