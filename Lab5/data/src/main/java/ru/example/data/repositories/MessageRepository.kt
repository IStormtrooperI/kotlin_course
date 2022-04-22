package ru.example.data.repositories

import ru.example.data.DBProvider
import ru.example.data.models.MessageDB

class MessageRepository {

    private val messageDao = DBProvider.instance.messageDao()

    companion object{
        val instance = MessageRepository()
    }

    fun getAllMessageData() = messageDao.getAllMessageData()

    suspend fun addMessage(model: MessageDB) = messageDao.addMessage(model)

    suspend fun deleteMessage(model: MessageDB) = messageDao.deleteMessage(model)

    suspend fun updateMessage(model: MessageDB) = messageDao.updateMessage(model)
}