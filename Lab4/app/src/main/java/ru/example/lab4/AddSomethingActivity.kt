package ru.example.lab4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.item_layout.*
import ru.example.lab4.`object`.Data
import ru.example.lab4.model.SomethingData

class AddSomethingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_something_activity)

        title = "Добавление"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val addButton = findViewById<View>(R.id.addToDoButton) as Button


        addButton.setOnClickListener {
            val titleEditText = findViewById<View>(R.id.title_text_view) as EditText

            if(titleEditText.text.length < 1){
                val alertDialog = AlertDialog.Builder(this@AddSomethingActivity)
                alertDialog.setMessage("Введите обязательные поля")
                alertDialog.show()
                return@setOnClickListener
            }

            val subtitleEditText = findViewById<View>(R.id.subtitle_text_view) as EditText
            val item = SomethingData(titleEditText.text.toString(),subtitleEditText.text.toString())
            Data.data.add(item)
            routeToMainActivity()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun routeToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}