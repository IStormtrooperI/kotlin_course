package ru.example.lab4

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.item_layout.*
import ru.example.lab4.`object`.Data
import ru.example.lab4.model.SomethingData

class SomethingActivity : AppCompatActivity() {

    companion object {
        const val SOMETHING_MODEL = "sgm"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.something_activity)
        val model = intent.getSerializableExtra(SOMETHING_MODEL) as? SomethingData
        title = "Подробнее"
        title_text_view.text = model?.title
        subtitle_text_view.text = model?.subtitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val removeButton = findViewById<View>(R.id.removeButton) as Button

        removeButton.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this@SomethingActivity)
            alertDialog.setMessage("Поздравляем. Задача выполнена")
            alertDialog.setPositiveButton(
                "Ок",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Data.data.remove(model)
                    routeToMainActivity()
                })
            alertDialog.show()
            return@setOnClickListener
        }
    }

    fun routeToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}