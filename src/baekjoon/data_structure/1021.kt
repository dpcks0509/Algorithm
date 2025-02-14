package baekjoon.data_structure

import java.util.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val targets = br.readLine().split(" ").map { it.toInt() }

    val deque = ArrayDeque((1..n).toList())
    var cnt = 0

    for (target in targets) {
        val index = deque.indexOf(target)
        val leftMoves = index
        val rightMoves = deque.size - index

        if (leftMoves <= rightMoves) {
            repeat(leftMoves) {
                deque.addLast(deque.removeFirst())
                cnt++
            }
        } else {
            repeat(rightMoves) {
                deque.addFirst(deque.removeLast())
                cnt++
            }
        }

        deque.removeFirst()
    }

    println(cnt)
}
