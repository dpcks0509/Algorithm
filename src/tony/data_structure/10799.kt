package tony.data_structure

import java.util.Stack

class `10799` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        var answer = 0

        val input = readLine().toList()
        val stack = Stack<Char>()
        var count = 0
        for (ch in input) {
            when (ch) {
                '(' -> {
                    stack.push(ch)
                    count++
                }

                ')' -> {
                    count--
                    answer += if (stack.pop() == '(') {
                        count
                    } else {
                        1
                    }
                    stack.push(ch)
                }
            }
        }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`10799`().solution())

    flush()
    close()
}