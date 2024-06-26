package data_structure

import java.util.Stack

class `10828` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val answer = StringBuilder()

        val stack = Stack<Int>()

        repeat(n) {
            val input = readLine().split(" ")
            val cmd = input[0]

            when (cmd) {
                "push" -> {
                    val num = input[1].toInt()
                    stack.push(num)
                }

                "pop" -> {
                    answer.append(if (stack.isNotEmpty()) "${stack.pop()}\n" else "-1\n")
                }

                "size" -> {
                    answer.append("${stack.size}\n")
                }

                "empty" -> {
                    answer.append(if (stack.isEmpty()) "1\n" else "0\n")
                }

                "top" -> {
                    answer.append(if (stack.isNotEmpty()) "${stack.peek()}\n" else "-1\n")
                }
            }
        }
        close()

        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`10828`().solution())

    flush()
    close()
}