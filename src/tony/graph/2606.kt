package tony.graph

class `2606` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val numberOfComputer = readLine().toInt()
            val numberOfPair = readLine().toInt()
            val pairs =
                Array(numberOfComputer + 1) {
                    mutableListOf<Int>()
                }

            val infected = Array(numberOfComputer + 1) { false }

            repeat(numberOfPair) {
                val (computer1, computer2) = readLine().split(' ').map { it.toInt() }
                pairs[computer1].add(computer2)
                pairs[computer2].add(computer1)
            }

            infected[1] = true
            var cnt = 0
            val recentlyInfected = mutableListOf(1)
            while (recentlyInfected.isNotEmpty()) {
                val num = recentlyInfected.removeFirst()
                pairs[num].forEach {
                    if(!infected[it]) {
                        infected[it] = true
                        recentlyInfected.add(it)
                        cnt++
                    }
                }
            }

            answer.append("$cnt")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`2606`().solution())

        flush()
        close()
    }
