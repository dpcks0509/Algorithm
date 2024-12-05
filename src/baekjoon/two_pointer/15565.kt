package baekjoon.two_pointer

import kotlin.math.min

class `15565` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            var answer = Int.MAX_VALUE

            val (n, k) = readLine().split(" ").map { it.toInt() }
            val list = readLine().split(" ").map { it.toInt() }

            var start = 0
            var end = 0
            val hashMap = HashMap<Int, Int>()

            while (end < n) {
                hashMap[list[end]] = hashMap.getOrDefault(list[end], 0) + 1
                if (hashMap.getOrDefault(LION, 0) >= k) {
                    answer = min(answer, hashMap.values.sum())
                    // 다음 1(라이언)을 찾을때 까지 반복
                    while (start < end) {
                        hashMap[list[start]] = hashMap.getOrDefault(list[start], 0) - 1
                        start++
                        if (list[start] == LION) break
                    }
                }
                end++
            }
            if (answer == Int.MAX_VALUE) answer = -1

            close()
            return answer.toString()
        }

    companion object {
        private const val LION = 1
    }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`15565`().solution())

        flush()
        close()
    }
