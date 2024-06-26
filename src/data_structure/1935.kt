package data_structure

import java.util.Stack

class `1935` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val input = readLine()

        val numbers = mutableListOf<Double>()
        repeat(n) {
            val num = readLine().toDouble()
            numbers.add(num)
        }

        val stack = Stack<Double>()
        for (ch in input) {
            if (ch in 'A'..'Z') {
                val index = ch - 'A'
                stack.push(numbers[index])
            } else {
                val top = stack.pop()
                stack.push(
                    when (ch) {
                        '+' -> {
                            stack.pop() + top
                        }

                        '-' -> {
                            stack.pop() - top
                        }

                        '*' -> {
                            stack.pop() * top
                        }

                        else -> {
                            stack.pop() / top
                        }
                    }
                )
            }
        }
        close()

        return String.format("%.2f", stack.pop())
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`1935`().solution())

    flush()
    close()
}