package tony.binary_search

class `1654` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            var answer = 0L

            val (k, n) = readLine().split(" ").map { it.toInt() }
            val numbers = LongArray(k) { readLine().toLong() }

            var start = 1L
            var end = numbers.max()

            while (start <= end) {
                val mid = (start + end) / 2
                val sum = numbers.sumOf { it / mid }

                if (sum >= n) {
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
        write(`1654`().solution())

        flush()
        close()
    }
