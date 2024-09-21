package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): String

    class Base(private val step: Int): Count{
        init {
            if (step <= 0) {
                throw IllegalStateException("step should be positive, but was $step")
            }
        }
        override fun increment(number: String): String {
            return (Integer.parseInt(number) + step).toString()
        }
    }
}

/**
 * интерфейс для счетчика
 *
interface Count {
    /**
     * увеличение счетчика на заданное значение
     *
     * @param number - текущее значение счетчика
     * @return - новое значение счетчика
     */
    fun increment(number: String): String
}

/**
 * реализация интерфейса Count
 *
 */
class Base(private val step: Int) : Count {
    /**
     * инициализация
     *
     * @throws IllegalStateException - если шаг не положителен
     */
    init {
        if (step <= 0) {
            throw IllegalStateException("step should be positive, but was $step")
        }
    }

    /**
     * реализация интерфейса
     *
     * @param number - текущее значение счетчика
     * @return - новое значение счетчика
     */
    override fun increment(number: String): String {
        return (Integer.parseInt(number) + step).toString()
    }
}
 */