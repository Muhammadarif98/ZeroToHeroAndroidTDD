package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var rootLayout: LinearLayout
    private lateinit var removeButton: Button
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.titleTextView)
        rootLayout = findViewById(R.id.rootLayout)
        removeButton = findViewById(R.id.removeButton)

        removeButton.setOnClickListener {
            rootLayout.removeView(textView)
            removeButton.isEnabled = false
        }
        if (savedInstanceState != null){
            rootLayout.removeView(textView)
            removeButton.isEnabled = false
        }
    }
}