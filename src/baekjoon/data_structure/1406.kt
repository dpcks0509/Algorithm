package baekjoon.data_structure

import java.util.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val str = br.readLine()
    val left = ArrayDeque<Char>()
    val right = ArrayDeque<Char>()

    str.forEach {
        left.add(it)
    }

    val m = br.readLine().toInt()

    repeat(m) {
        val input = br.readLine().split(" ")

        when (input[0]) {
            "L" -> {
                if (left.isNotEmpty()) {
                    right.addFirst(left.removeLast())
                }
            }

            "D" -> {
                if (right.isNotEmpty()) {
                    left.add(right.removeFirst())
                }
            }

            "B" -> {
                if (left.isNotEmpty()) {
                    left.removeLast()
                }
            }

            "P" -> {
                val ch = input[1].first()
                left.add(ch)
            }
        }
    }

    bw.write(left.joinToString("") + right.joinToString(""))
    bw.flush()
    bw.close()
    br.close()
}