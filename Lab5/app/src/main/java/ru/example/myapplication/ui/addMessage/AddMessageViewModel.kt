package ru.example.myapplication.ui.addMessage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.example.data.models.MessageDB
import ru.example.data.repositories.MessageRepository

class AddMessageViewModel : ViewModel() {

    fun addMessageModel(message: String, fullName: String){
        viewModelScope.launch {
            val model = MessageDB(
                message = message,
                fullName = fullName
            )
            MessageRepository.instance.addMessage(model)
        }
    }

    fun deleteMessageModel(model: MessageDB){
        viewModelScope.launch {
            MessageRepository.instance.deleteMessage(model)
        }
    }
}