package ru.example.myapplication.app

import android.app.Application
import ru.example.data.DBProvider

class App: Application() {
    override  fun onCreate(){
        super.onCreate()
        DBProvider.create(this)
    }
}