package tony.two_pointer

class `21921` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, x) = readLine().split(" ").map { it.toInt() }
            val list = readLine().split(" ").map { it.toInt() }

            var sum = 0
            for (i in 0 until x) {
                sum += list[i]
            }
            var max = sum
            var count = 1

            for (i in 0 until n - x) {
                sum += list[i + x]
                sum -= list[i]

                if (sum > max) {
                    max = sum
                    count = 1
                } else if (sum == max) {
                    count++
                }
            }

            if (max == 0) {
                answer.append("SAD")
            } else {
                answer.append("$max\n")
                answer.append("$count\n")
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`21921`().solution())

        flush()
        close()
    }
