package ru.example.myapplication.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.example.data.models.MessageDB
import ru.example.data.repositories.MessageRepository

class ChatViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is chat Fragment"
    }
    val text: LiveData<String> = _text

    fun observeAllMessage() = MessageRepository.instance.getAllMessageData()

    fun addMessageModel(){
        viewModelScope.launch {
            val model = MessageDB(
                message = "Лиса – млекопитающий хищник небольших размеров. В биологической классификации многочисленный род лисиц относят к семейству псовых.",
                fullName = "Ольга Александровна Матвеева"
            )
            MessageRepository.instance.addMessage(model)
        }
    }

    fun deleteMessageModel(model: MessageDB){
        viewModelScope.launch {
            MessageRepository.instance.deleteMessage(model)
        }
    }

    fun updateMessageModel(model: MessageDB){
        viewModelScope.launch {
            model.message = "Лиса – млекопитающий хищник небольших размеров. В биологической классификации многочисленный род лисиц относят к семейству псовых."
            model.fullName = "Ольга Александровна Матвеева"
            MessageRepository.instance.updateMessage(model)
        }
    }
}