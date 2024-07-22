package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var changeButton: Button
    private val textToSave = "I am an Android Developer!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.titleTextView)
        changeButton = findViewById(R.id.changeButton)

        if (savedInstanceState != null) {
            val savedText = savedInstanceState.getString("savedText")
            titleTextView.text = savedText
        } else {
            titleTextView.text = "Hello World!"
        }

        changeButton.setOnClickListener {
            titleTextView.text = textToSave
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("savedText", titleTextView.text.toString())
    }
}