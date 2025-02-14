package baekjoon.data_structure

import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    var cnt = 0

    for (i in 0 until n) {
        val word = br.readLine()

        if (word.length % 2 != 0) continue

        val stack = Stack<Char>()

        for (j in 0 until word.length) {
            if (stack.isEmpty()) {
                stack.push(word[j])
            } else {
                if (stack.peek() == word[j]) {
                    stack.pop()
                } else {
                    stack.push(word[j])
                }
            }
        }

        if (stack.isEmpty()) cnt++
    }

    println(cnt)
}