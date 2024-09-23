package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var linearLayout: LinearLayout
    private lateinit var button: Button

    private val count = Count.Base(step = 5,max =10)
    private var uiState: UiState = UiState.Base("0")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        linearLayout = findViewById(R.id.rootLayout)
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            uiState = count.increment(number = textView.text.toString())
            uiState.apply(textView,button)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY,uiState)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable(KEY,UiState::class.java) as UiState
        uiState.apply(textView,button)
    }
    companion object{
        private val KEY = "uiStateKey"
    }
}

