package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var linearLayout: LinearLayout
    private lateinit var removeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.titleTextView)
        linearLayout = findViewById(R.id.rootLayout)
        removeButton = findViewById(R.id.removeButton)

        if (savedInstanceState != null) {
            linearLayout.removeView(titleTextView)
        }

        removeButton.setOnClickListener {
           linearLayout.removeView(titleTextView)
        }
    }
}
