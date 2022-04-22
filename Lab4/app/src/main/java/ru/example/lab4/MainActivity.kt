package ru.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.example.lab4.`object`.Data
import ru.example.lab4.adapter.SimpleAdapter
import ru.example.lab4.model.SomethingData

class MainActivity : AppCompatActivity() {

    companion object {
        const val  MAIN_MODEL = "main"
    }

    private val adapter by lazy {
        SimpleAdapter {
            routeToSomethingActivity(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu_custom, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.addToDo -> {
                routeToAddSomethingActivity()
            }
        }
        return true
    }

    private fun routeToSomethingActivity(model: SomethingData) {
        val intent = Intent(this, SomethingActivity::class.java).apply {
            putExtra(SomethingActivity.SOMETHING_MODEL, model)
        }
        startActivity(intent)
    }

    private fun routeToAddSomethingActivity() {
        val intent = Intent(this, AddSomethingActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.apply {
            title = "Список дел"
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        adapter.set(Data.data)
    }
}