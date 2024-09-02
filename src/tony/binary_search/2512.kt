package tony.binary_search

class `2512` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            var answer = 0L

            val n = readLine().toInt()
            val numbers = readLine().split(" ").map { it.toLong() }
            val target = readLine().toLong()

            var start = 0L
            var end = numbers.max()

            if (numbers.sum() <= target) {
                answer = numbers.max()
            } else {
                while (start <= end) {
                    val mid = (start + end) / 2
                    val sum =
                        numbers.sumOf {
                            if (mid > it) it else mid
                        }

                    if (sum <= target) {
                        start = mid + 1
                        answer = mid
                    } else {
                        end = mid - 1
                    }
                }
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`2512`().solution())

        flush()
        close()
    }
