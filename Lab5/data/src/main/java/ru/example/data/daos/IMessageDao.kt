package ru.example.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.example.data.models.MessageDB

@Dao
interface IMessageDao {

    @Query("SELECT * FROM message_table")
    fun getAllMessageData(): LiveData<List<MessageDB>>

    @Insert
    suspend fun addMessage(model: MessageDB)

    @Delete
    suspend fun deleteMessage(model: MessageDB)

    @Update
    suspend fun updateMessage(model: MessageDB)
}