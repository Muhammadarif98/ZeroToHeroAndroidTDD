package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var linearLayout: LinearLayout
    private lateinit var button: Button
    private lateinit var count: Count

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        linearLayout = findViewById(R.id.rootLayout)
        button = findViewById(R.id.incrementButton)

        count = Count.Base(step = 5, max = 10)

        button.setOnClickListener {
            val result = count.increment(number = textView.text.toString())
            textView.text = when (result) {
                is UiState.Base -> result.text
                is UiState.Max -> {
                    button.isEnabled = false
                    result.text
                }

                else -> ({}).toString()
            }
        }

        if (savedInstanceState == null) {
            textView.text = "0"
        } else {
            textView.text = savedInstanceState.getString("count")
            if (textView.text.toString().toInt() >= 4) {
                button.isEnabled = false
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("count", textView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState.getString("count")
        if (textView.text.toString().toInt() >= 4) {
            button.isEnabled = false
        }
    }
}

