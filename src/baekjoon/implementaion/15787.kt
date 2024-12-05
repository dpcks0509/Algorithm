package baekjoon.implementaion

class `15787` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, m) = readLine().split(' ').map { it.toInt() }
            val trains = Array(n) { IntArray(20) }

            repeat(m) {
                val input = readLine().split(' ').map { it.toInt() }
                val cmd = input[0]
                val i = input[1] - 1
                when (cmd) {
                    1 -> {
                        val x = input[2] - 1
                        trains[i][x] = 1
                    }

                    2 -> {
                        val x = input[2] - 1
                        trains[i][x] = 0
                    }

                    3 -> {
                        for (j in 18 downTo 0) {
                            trains[i][j + 1] = trains[i][j]
                        }
                        trains[i][0] = 0
                    }

                    4 -> {
                        for (j in 1..19) {
                            trains[i][j - 1] = trains[i][j]
                        }
                        trains[i][19] = 0
                    }
                }
            }

            val cnt =
                trains
                    .map { train ->
                        train.joinToString()
                    }.toSet()
                    .size

            answer.append("$cnt")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`15787`().solution())

        flush()
        close()
    }
