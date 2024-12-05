package baekjoon.two_pointer

class `20922` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            var answer = 0

            val (n, k) = readLine().split(" ").map { it.toInt() }
            val list = readLine().split(" ").map { it.toInt() }

            val hashMap = hashMapOf<Int, Int>()
            var start = 0
            var end = 0

            while (end < n) {
                hashMap[list[end]] = hashMap.getOrDefault(list[end], 0) + 1
                while (hashMap.getOrDefault(list[end], 0) > k) {
                    hashMap[list[start]] = hashMap.getOrDefault(list[start], 0) - 1
                    start++
                }
                end++
                answer = maxOf(answer, end - start)
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`20922`().solution())

        flush()
        close()
    }
