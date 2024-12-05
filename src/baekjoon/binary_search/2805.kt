package baekjoon.binary_search

class `2805` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            var answer = 0L

            val (n, m) = readLine().split(" ").map { it.toLong() }
            val trees = readLine().split(" ").map { it.toLong() }

            var start = 0L
            var end = trees.max()

            while (start <= end) {
                val mid = (start + end) / 2
                val sum =
                    trees.sumOf {
                        val num = it - mid
                        if (num > 0) num else 0
                    }

                if (sum == m) {
                    answer = mid
                    break
                } else if (sum > m) {
                    start = mid + 1
                    answer = mid
                } else {
                    end = mid - 1
                }
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`2805`().solution())

        flush()
        close()
    }
