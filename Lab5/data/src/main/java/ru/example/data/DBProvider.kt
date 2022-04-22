package ru.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.example.data.daos.IMessageDao
import ru.example.data.models.MessageDB

@Database(entities = [MessageDB::class], version = 1)
abstract class DBProvider : RoomDatabase() {

    companion object{
        lateinit var  instance: DBProvider

        fun create(context: Context){
            instance = Room.databaseBuilder(context, DBProvider::class.java, "database").build()

        }
    }

    abstract fun messageDao(): IMessageDao
}