package ru.example.lab1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<View>(R.id.button)
        val text = findViewById<View>(R.id.textView) as TextView

        btn.setOnClickListener {
            text.visibility = View.VISIBLE
        }

    }
}