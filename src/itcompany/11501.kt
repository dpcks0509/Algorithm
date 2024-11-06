package itcompany

class `11501` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val t = readLine().toInt()
            repeat(t) {
                val n = readLine().toInt()
                val numbers = readLine().split(' ').map { it.toInt() }.reversed()

                var max = numbers[0]
                var profit: Long = 0
                for (i in 1 until numbers.size) {
                    if (numbers[i] < max) {
                        profit += max - numbers[i]
                    }

                    if (numbers[i] > max) {
                        max = numbers[i]
                    }
                }

                answer.append("$profit\n")
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`11501`().solution())

        flush()
        close()
    }
