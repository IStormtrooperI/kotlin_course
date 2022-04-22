package ru.example.lab3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAC = findViewById<View>(R.id.button18) as Button
        val btn = findViewById<View>(R.id.button) as Button
        val btnResult = findViewById<View>(R.id.button19) as Button

        val btn0 = findViewById<View>(R.id.button17) as Button
        val btn1 = findViewById<View>(R.id.button12) as Button
        val btn2 = findViewById<View>(R.id.button14) as Button
        val btn3 = findViewById<View>(R.id.button13) as Button
        val btn4 = findViewById<View>(R.id.button9) as Button
        val btn5 = findViewById<View>(R.id.button11) as Button
        val btn6 = findViewById<View>(R.id.button10) as Button
        val btn7 = findViewById<View>(R.id.button4) as Button
        val btn8 = findViewById<View>(R.id.button3) as Button
        val btn9 = findViewById<View>(R.id.button2) as Button

        val btnPlus = findViewById<View>(R.id.button8) as Button
        val btnMinus = findViewById<View>(R.id.button6) as Button
        val btnDivide = findViewById<View>(R.id.button7) as Button
        val btnMultiply = findViewById<View>(R.id.button5) as Button

        val btnNumberSign = findViewById<View>(R.id.button15) as Button
        val btnComma = findViewById<View>(R.id.button16) as Button


        val result = findViewById<View>(R.id.textView2) as TextView
        val solutionCourseTextView = findViewById<View>(R.id.textView) as TextView

        val solutionCourseArray = arrayListOf<String>()
        var isResult = false

        btnAC.setOnClickListener {
            solutionCourseTextView.text = ""
            solutionCourseArray.clear()
            result.text = "0"
            isResult = false
        }

        btn.setOnClickListener {
            if(result.text.length == 2 && result.text[0].toString() == "-"){
                result.text = "0"
                isResult = false
            }
            else if (result.text.length > 1 && !isResult) {
                result.text = result.text.dropLast(1)
            } else {
                result.text = "0"
                isResult = false
            }
        }



        btn0.setOnClickListener {
            if (result.text != "0" && !isResult) {
                result.text = result.text.toString() + "0"
            } else {
                result.text = "0"
                isResult = false
            }
        }

        btn1.setOnClickListener {
            if (result.text == "0" || isResult) {
                result.text = "1"
                isResult = false
            } else {
                result.text = result.text.toString() + "1"
            }
        }

        btn2.setOnClickListener {
            if (result.text == "0" || isResult) {
                result.text = "2"
                isResult = false
            } else {
                result.text = result.text.toString() + "2"
            }
        }

        btn3.setOnClickListener {
            if (result.text == "0" || isResult) {
                result.text = "3"
                isResult = false
            } else {
                result.text = result.text.toString() + "3"
            }
        }

        btn4.setOnClickListener {
            if (result.text == "0" || isResult) {
                result.text = "4"
                isResult = false
            } else {
                result.text = result.text.toString() + "4"
            }
        }

        btn5.setOnClickListener {
            if (result.text == "0" || isResult) {
                result.text = "5"
                isResult = false
            } else {
                result.text = result.text.toString() + "5"
            }
        }

        btn6.setOnClickListener {
            if (result.text == "0" || isResult) {
                result.text = "6"
                isResult = false
            } else {
                result.text = result.text.toString() + "6"
            }
        }

        btn7.setOnClickListener {
            if (result.text == "0" || isResult) {
                result.text = "7"
                isResult = false
            } else {
                result.text = result.text.toString() + "7"
            }
        }

        btn8.setOnClickListener {
            if (result.text == "0" || isResult) {
                result.text = "8"
                isResult = false
            } else {
                result.text = result.text.toString() + "8"
            }
        }

        btn9.setOnClickListener {
            if (result.text == "0" || isResult) {
                result.text = "9"
                isResult = false
            } else {
                result.text = result.text.toString() + "9"
            }
        }

        btnNumberSign.setOnClickListener {
            if (result.text != "0") {
                isResult = false
                if (result.text.take(1) != "-") {
                    result.text = "-" + result.text.toString()
                } else {
                    result.text = result.text.drop(1)
                }
            }
        }

        btnComma.setOnClickListener {
            if (isResult) {
                result.text = "0."
                isResult = false
            } else if (!result.text.contains(",")) {
                result.text = result.text.toString() + "."
            }
        }

        btnResult.setOnClickListener {
            when {
                solutionCourseArray.isEmpty() -> {
                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("=")
                    result.text = result.text.toString()
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                }
                solutionCourseArray.contains("=") -> {
                    solutionCourseArray.clear()
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("=")
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                    isResult = true
                }
                else -> {
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("=")


                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }

                    var resultOfSolution = 0.0
                    val solution = arrayListOf<String>()
                    solution.addAll(solutionCourseArray)
                    solution.removeAt(solution.size - 1)

                    while (solution.contains("*") || solution.contains("/")) {
                        var currentElement = -1
                        when {
                            solution.indexOf("*") == -1 -> currentElement = solution.indexOf("/")
                            solution.indexOf("/") == -1 -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") > solution.indexOf("*") -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") < solution.indexOf("*") -> currentElement = solution.indexOf("/")
                        }

                        if (solution[currentElement] == "*")
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() * solution[currentElement + 1].toDouble()).toString()
                        else
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() / solution[currentElement + 1].toDouble()).toString()
                        solution.removeAt(currentElement + 1)
                        solution.removeAt(currentElement - 1)
                    }

                    if (solution.size == 1)
                        resultOfSolution = solution[0].toDouble()

                    if (solution.contains("+") || solution.contains("-"))
                        for (i in 0 until solution.size step 2) {
                            if (i > 0) {
                                if (solution[i - 1] == "+")
                                    resultOfSolution += solution[i].toDouble()
                                else
                                    resultOfSolution -= solution[i].toDouble()
                            } else {
                                resultOfSolution += solution[i].toDouble()
                            }
                        }

                    if (resultOfSolution % 1 == 0.0)
                        result.text = resultOfSolution.toInt().toString()
                    else
                        result.text = String.format("%.3f", resultOfSolution)
                    isResult = true
                }
            }
        }

        btnPlus.setOnClickListener {
            when {
                solutionCourseArray.isEmpty() -> {
                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("+")
                    result.text = "0"
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                }
                solutionCourseArray.contains("=") -> {
                    solutionCourseArray.clear()
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("+")
                    result.text = "0"
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                }
                else -> {
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("+")

                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }

                    var resultOfSolution = 0.0
                    val solution = arrayListOf<String>()
                    solution.addAll(solutionCourseArray)
                    solution.removeAt(solution.size - 1)

                    while (solution.contains("*") || solution.contains("/")) {
                        var currentElement = -1
                        when {
                            solution.indexOf("*") == -1 -> currentElement = solution.indexOf("/")
                            solution.indexOf("/") == -1 -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") > solution.indexOf("*") -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") < solution.indexOf("*") -> currentElement = solution.indexOf("/")
                        }

                        if (solution[currentElement] == "*")
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() * solution[currentElement + 1].toDouble()).toString()
                        else
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() / solution[currentElement + 1].toDouble()).toString()
                        solution.removeAt(currentElement + 1)
                        solution.removeAt(currentElement - 1)
                    }

                    if (solution.size == 1)
                        resultOfSolution = solution[0].toDouble()

                    if (solution.contains("+") || solution.contains("-"))
                        for (i in 0 until solution.size step 2) {
                            if (i > 0) {
                                if (solution[i - 1] == "+")
                                    resultOfSolution += solution[i].toDouble()
                                else
                                    resultOfSolution -= solution[i].toDouble()
                            } else {
                                resultOfSolution += solution[i].toDouble()
                            }
                        }

                    if (resultOfSolution % 1 == 0.0)
                        result.text = resultOfSolution.toInt().toString()
                    else
                        result.text = String.format("%.3f", resultOfSolution)
                    isResult = true
                }
            }
        }

        btnMinus.setOnClickListener {
            when {
                solutionCourseArray.isEmpty() -> {
                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("-")
                    result.text = "0"
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                }
                solutionCourseArray.contains("=") -> {
                    solutionCourseArray.clear()
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("-")
                    result.text = "0"
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                }
                else -> {
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("-")

                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }

                    var resultOfSolution = 0.0
                    val solution = arrayListOf<String>()
                    solution.addAll(solutionCourseArray)
                    solution.removeAt(solution.size - 1)

                    while (solution.contains("*") || solution.contains("/")) {
                        var currentElement = -1
                        when {
                            solution.indexOf("*") == -1 -> currentElement = solution.indexOf("/")
                            solution.indexOf("/") == -1 -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") > solution.indexOf("*") -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") < solution.indexOf("*") -> currentElement = solution.indexOf("/")
                        }

                        if (solution[currentElement] == "*")
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() * solution[currentElement + 1].toDouble()).toString()
                        else
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() / solution[currentElement + 1].toDouble()).toString()
                        solution.removeAt(currentElement + 1)
                        solution.removeAt(currentElement - 1)
                    }

                    if (solution.size == 1)
                        resultOfSolution = solution[0].toDouble()

                    if (solution.contains("+") || solution.contains("-"))
                        for (i in 0 until solution.size step 2) {
                            if (i > 0) {
                                if (solution[i - 1] == "+")
                                    resultOfSolution += solution[i].toDouble()
                                else
                                    resultOfSolution -= solution[i].toDouble()
                            } else {
                                resultOfSolution += solution[i].toDouble()
                            }
                        }

                    if (resultOfSolution % 1 == 0.0)
                        result.text = resultOfSolution.toInt().toString()
                    else
                        result.text = String.format("%.3f", resultOfSolution)
                    isResult = true
                }
            }
        }

        btnMultiply.setOnClickListener {
            when {
                solutionCourseArray.isEmpty() -> {
                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("*")
                    result.text = "0"
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                }
                solutionCourseArray.contains("=") -> {
                    solutionCourseArray.clear()
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("*")
                    result.text = "0"
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                }
                else -> {
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("*")

                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }

                    var resultOfSolution = 0.0
                    val solution = arrayListOf<String>()
                    solution.addAll(solutionCourseArray)
                    solution.removeAt(solution.size - 1)

                    while (solution.contains("*") || solution.contains("/")) {
                        var currentElement = -1
                        when {
                            solution.indexOf("*") == -1 -> currentElement = solution.indexOf("/")
                            solution.indexOf("/") == -1 -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") > solution.indexOf("*") -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") < solution.indexOf("*") -> currentElement = solution.indexOf("/")
                        }

                        if (solution[currentElement] == "*")
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() * solution[currentElement + 1].toDouble()).toString()
                        else
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() / solution[currentElement + 1].toDouble()).toString()
                        solution.removeAt(currentElement + 1)
                        solution.removeAt(currentElement - 1)
                    }

                    if (solution.size == 1)
                        resultOfSolution = solution[0].toDouble()

                    if (solution.contains("+") || solution.contains("-"))
                        for (i in 0 until solution.size step 2) {
                            if (i > 0) {
                                if (solution[i - 1] == "+")
                                    resultOfSolution += solution[i].toDouble()
                                else
                                    resultOfSolution -= solution[i].toDouble()
                            } else {
                                resultOfSolution += solution[i].toDouble()
                            }
                        }

                    if (resultOfSolution % 1 == 0.0)
                        result.text = resultOfSolution.toInt().toString()
                    else
                        result.text = String.format("%.3f", resultOfSolution)
                    isResult = true
                }
            }
        }

        btnDivide.setOnClickListener {
            when {
                solutionCourseArray.isEmpty() -> {
                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("/")
                    result.text = "0"
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                }
                solutionCourseArray.contains("=") -> {
                    solutionCourseArray.clear()
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("/")
                    result.text = "0"
                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }
                }
                else -> {
                    solutionCourseTextView.text = ""

                    solutionCourseArray.add(result.text.toString())
                    solutionCourseArray.add("/")

                    solutionCourseArray.forEach {
                        solutionCourseTextView.text =
                            solutionCourseTextView.text.toString() + it + " "
                    }

                    var resultOfSolution = 0.0
                    val solution = arrayListOf<String>()
                    solution.addAll(solutionCourseArray)
                    solution.removeAt(solution.size - 1)

                    while (solution.contains("*") || solution.contains("/")) {
                        var currentElement = -1
                        when {
                            solution.indexOf("*") == -1 -> currentElement = solution.indexOf("/")
                            solution.indexOf("/") == -1 -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") > solution.indexOf("*") -> currentElement = solution.indexOf("*")
                            solution.indexOf("/") < solution.indexOf("*") -> currentElement = solution.indexOf("/")
                        }

                        if (solution[currentElement] == "*")
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() * solution[currentElement + 1].toDouble()).toString()
                        else
                            solution[currentElement] =
                                (solution[currentElement - 1].toDouble() / solution[currentElement + 1].toDouble()).toString()
                        solution.removeAt(currentElement + 1)
                        solution.removeAt(currentElement - 1)
                    }

                    if (solution.size == 1)
                        resultOfSolution = solution[0].toDouble()

                    if (solution.contains("+") || solution.contains("-"))
                        for (i in 0 until solution.size step 2) {
                            if (i > 0) {
                                if (solution[i - 1] == "+")
                                    resultOfSolution += solution[i].toDouble()
                                else
                                    resultOfSolution -= solution[i].toDouble()
                            } else {
                                resultOfSolution += solution[i].toDouble()
                            }
                        }

                    if (resultOfSolution % 1 == 0.0)
                        result.text = resultOfSolution.toInt().toString()
                    else
                        result.text = String.format("%.3f", resultOfSolution)
                    isResult = true
                }
            }
        }
    }
}