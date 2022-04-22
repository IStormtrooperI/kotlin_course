package ru.example.lab2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<View>(R.id.button) as Button

        val objectA = findViewById<View>(R.id.koefa) as EditText
        val objectB = findViewById<View>(R.id.koefb) as EditText
        val objectC = findViewById<View>(R.id.koefc) as EditText


        btn.setOnClickListener {

            val alertDialog = AlertDialog.Builder(this@MainActivity)


            val a = objectA.text.toString().toDoubleOrNull()
            val b = objectB.text.toString().toDoubleOrNull()
            val c = objectC.text.toString().toDoubleOrNull()

            if(a == null || b == null || c == null){
                alertDialog.setMessage("Введены некорректные значения")
                alertDialog.show()
                return@setOnClickListener
            }

            if(b == 0.0 && c == 0.0 && a == 0.0){
                alertDialog.setMessage("Корней нет")
                alertDialog.show()
                return@setOnClickListener
            } else if(b == 0.0 && c == 0.0 && a != 0.0){
                alertDialog.setMessage("x1=0.0")
                alertDialog.show()
                return@setOnClickListener
            } else if(b == 0.0 && c != 0.0 && a != 0.0){
                val d = b * b - 4 * a * c
                when {
                    d < 0.0 -> {
                        alertDialog.setMessage("Корней нет")
                        alertDialog.show()
                    }
                    d > 0.0 -> {
                        val kor1 = (-b + sqrt(d)) / (2 * a)
                        val kor2 = (-b - sqrt(d)) / (2 * a)
                        alertDialog.setMessage("x1="+ String.format("%.3f",(kor1)) + ",x2=" + String.format("%.3f",(kor2)))
                        alertDialog.show()
                    }
                    d== 0.0 -> {
                        val kor1 = (-b / (2 * a))
                        alertDialog.setMessage("x1=x2="+ String.format("%.3f",(kor1)))
                        alertDialog.show()
                    }
                }
                return@setOnClickListener
            } else if(b == 0.0 && c != 0.0 && a == 0.0){
                alertDialog.setMessage("Корней нет")
                alertDialog.show()
                return@setOnClickListener
            } else if(b != 0.0 && c != 0.0 && a == 0.0){
                val kor1 = (-c/b)
                alertDialog.setMessage("x1="+String.format("%.3f",kor1))
                alertDialog.show()
                return@setOnClickListener
            } else if(b != 0.0 && c == 0.0 && a != 0.0){
                val kor1 = (b/a)
                alertDialog.setMessage("x1=0.0,x2="+String.format("%.3f",kor1))
                alertDialog.show()
                return@setOnClickListener
            }

            val d = b * b - 4 * a * c

            when {
                d < 0.0 -> {
                    alertDialog.setMessage("Корней нет")
                    alertDialog.show()
                }
                d == 0.0 -> {
                    val kor1 = (-b / (2 * a))
                    alertDialog.setMessage("x1=x2="+String.format("%.3f",kor1))
                    alertDialog.show()
                }
                else -> {
                    val kor1 = ((-b + sqrt(d)) / (2 * a))
                    val kor2 = ((-b - sqrt(d)) / (2 * a))
                    alertDialog.setMessage("x1="+String.format("%.3f",kor1)+",x2="+String.format("%.3f",kor2))
                    alertDialog.show()
                }
            }



        }

    }
}