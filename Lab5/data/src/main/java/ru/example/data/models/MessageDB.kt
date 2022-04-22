package ru.example.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "message_table")
data class MessageDB (
    @PrimaryKey var uuid: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "sm_message") var message: String,
    @ColumnInfo(name = "sm_fullName") var fullName: String,
):Serializable