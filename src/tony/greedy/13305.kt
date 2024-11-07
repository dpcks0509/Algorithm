package tony.greedy

class `13305` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            val distanceList = readLine().split(' ').map { it.toLong() }
            val priceList = readLine().split(' ').map { it.toLong() }

            var totalPrice = 0L
            var currentPrice = priceList[0]

            for (i in 0 until n - 1) {
                val nextPrice = priceList[i + 1]

                totalPrice += currentPrice * distanceList[i]

                if (currentPrice > nextPrice) {
                    currentPrice = nextPrice
                }
            }

            answer.append(totalPrice)

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`13305`().solution())

        flush()
        close()
    }
