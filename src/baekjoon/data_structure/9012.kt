package baekjoon.data_structure

import java.util.Stack

class `9012` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val answer = StringBuilder()

        repeat(n) {
            val input = readLine()

            val stack = Stack<Char>()
            var isVPS = true

            for (ch in input) {
                when (ch) {
                    '(' -> {
                        stack.push(ch)
                    }

                    ')' -> {
                        if (stack.isEmpty()) {
                            isVPS = false
                            break
                        }
                        stack.pop()
                    }
                }
            }

            if (stack.isNotEmpty()) isVPS = false
            answer.append(if (isVPS) "YES\n" else "NO\n")
        }
        close()

        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`9012`().solution())

    flush()
    close()
}