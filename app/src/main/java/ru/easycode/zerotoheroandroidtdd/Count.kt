package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView

interface Count {
    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {
        init {
            if (step < 1) {
                throw IllegalStateException("step should be positive, but was $step")
            }
            if (max < 1) {
                throw IllegalStateException("max should be positive, but was $max")
            }
            if (max < step) {
                throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {
            val current = Integer.parseInt(number)
            val newValue = current + step
            return  if (newValue + step <= max) {
                UiState.Base(text = newValue.toString())
            } else {
                UiState.Max(text = newValue.toString())
            }
        }
    }

}

