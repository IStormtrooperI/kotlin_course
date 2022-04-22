package ru.example.myapplication

import android.content.ClipData
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.button.MaterialButton
import ru.example.myapplication.databinding.ActivityMainBinding
import androidx.navigation.findNavController as findNavController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null)
            supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_chat, R.id.navigation_quiz
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_chat -> {
                    val appBarTitle = findViewById<View>(R.id.app_bar_title) as TextView

                    val closeButton = findViewById<View>(R.id.close) as MaterialButton

                    val addMessageButton = findViewById<View>(R.id.add_message) as MaterialButton

                    appBarTitle.text = getString(R.string.title_chat)

                    closeButton.visibility = View.GONE

                    addMessageButton.visibility = View.VISIBLE

                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_quiz -> {

                    val appBarTitle = findViewById<View>(R.id.app_bar_title) as TextView

                    val closeButton = findViewById<View>(R.id.close) as MaterialButton

                    val addMessageButton = findViewById<View>(R.id.add_message) as MaterialButton

                    appBarTitle.text = getString(R.string.title_quiz)

                    closeButton.visibility = View.GONE

                    addMessageButton.visibility = View.GONE


                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_addMessage -> {

                    val appBarTitle = findViewById<View>(R.id.app_bar_title) as TextView

                    val closeButton = findViewById<View>(R.id.close) as MaterialButton

                    val addMessageButton = findViewById<View>(R.id.add_message) as MaterialButton

                    appBarTitle.text = getString(R.string.title_add_message)

                    closeButton.visibility = View.VISIBLE

                    addMessageButton.visibility = View.GONE


                    navView.visibility = View.VISIBLE
                }
                else -> navView.visibility = View.GONE
            }
        }

        val appBarTitle = findViewById<View>(R.id.app_bar_title) as TextView

        val closeButton = findViewById<View>(R.id.close) as MaterialButton

        val addMessageButton = findViewById<View>(R.id.add_message) as MaterialButton

        appBarTitle.text = getString(R.string.title_chat)

        closeButton.visibility = View.GONE

        addMessageButton.visibility = View.VISIBLE

        addMessageButton.setOnClickListener {
            navController.navigate(R.id.action_navigation_chat_to_addMessage)
        }

        closeButton.setOnClickListener {
            navController.navigate(R.id.action_navigation_addMessage_to_chat)
        }
    }
}