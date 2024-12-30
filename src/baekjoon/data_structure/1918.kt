package baekjoon.data_structure

import java.util.Stack

fun main() {
    val input = readln().toCharArray()


    fun priority(op: Char): Int {
        return when (op) {
            '+', '-' -> 1
            '*', '/' -> 2
            else -> 0
        }
    }

    val stack = Stack<Char>()
    var answer = ""

    for (ch in input) {
        when (ch) {
            in 'A'..'Z' -> {
                answer += ch
            }

            '(' -> {
                stack.push(ch)
            }

            ')' -> {
                while (stack.isNotEmpty() && stack.peek() != '(') {
                    answer += stack.pop()
                }
                stack.pop()
            }

            else -> {
                while (stack.isNotEmpty() && priority(stack.peek()) >= priority(ch)) {
                    answer += stack.pop()
                }
                stack.push(ch)
            }
        }
    }

    while (stack.isNotEmpty()) {
        answer += stack.pop()
    }

    println(answer)
}
