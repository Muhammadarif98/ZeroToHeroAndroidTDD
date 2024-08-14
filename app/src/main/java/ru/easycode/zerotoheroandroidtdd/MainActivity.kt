package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var changeButton: Button
    private var isTitleVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.titleTextView)
        changeButton = findViewById(R.id.hideButton)

        if (savedInstanceState != null) {
            isTitleVisible = savedInstanceState.getBoolean("isTitleVisible", true)
            titleTextView.visibility = if (isTitleVisible) View.VISIBLE else View.GONE
        } else {
            titleTextView.text = "Hello World!"
        }

        changeButton.setOnClickListener {
            isTitleVisible = !isTitleVisible
            titleTextView.visibility = if (isTitleVisible) View.VISIBLE else View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isTitleVisible", titleTextView.visibility == View.VISIBLE)
    }
}