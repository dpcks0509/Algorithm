package brute_force

class `1969` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, m) = readLine().split(" ").map { it.toInt() }
            val strList = Array(n) { readLine() }

            var str = ""
            for (i in 0 until m) {
                val cntList = IntArray(4) { 0 }
                for (j in 0 until n) {
                    when (strList[j][i]) {
                        'A' -> cntList[0]++
                        'C' -> cntList[1]++
                        'G' -> cntList[2]++
                        else -> cntList[3]++
                    }
                }

                val max = cntList.maxOf { it }
                val idx = cntList.indexOf(max)

                str +=
                    when (idx) {
                        0 -> 'A'
                        1 -> 'C'
                        2 -> 'G'
                        else -> 'T'
                    }
            }

            var cnt = 0
            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (str[j] != strList[i][j]) cnt++
                }
            }

            answer.append("${str}\n")
            answer.append("${cnt}\n")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1969`().solution())

        flush()
        close()
    }
