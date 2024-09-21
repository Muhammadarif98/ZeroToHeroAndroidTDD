package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {
        init {
            if (step <= 0) {
                throw IllegalStateException("step should be positive, but was $step")
            }
            if (max <= 0) {
                throw IllegalStateException("max should be positive, but was $max")
            }
            if (max < step) {
                throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {
            val current = Integer.parseInt(number)
            val newValue = current + step
            return if (newValue >= max) {
                UiState.Max(text = max.toString())
            } else if (newValue + step > max) {
                UiState.Max(text = newValue.toString())
            } else {
                UiState.Base(text = newValue.toString())
            }
        }
    }

}

sealed class UiState {
    data class Base(val text: String) : UiState()
    data class Max(val text: String) : UiState()
}
