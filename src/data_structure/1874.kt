package data_structure

import java.util.Stack

class `1874` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val answer = StringBuilder()

        val stack = Stack<Int>()
        var current = 1
        repeat(n) {
            val target = readLine().toInt()
            while (current <= target) {
                stack.push(current)

                current++
                answer.append("+\n")
            }

            if (stack.peek() == target) {
                stack.pop()

                answer.append("-\n")
            } else {
                return "NO"
            }
        }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`1874`().solution())

    flush()
    close()
}