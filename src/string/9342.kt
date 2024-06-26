package string

class `9342` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val answer = StringBuilder()

        val n = readLine().toInt()
        repeat(n) {
            val str = readLine()

            var lastChar = 'A'
            var isPattern = false
            val validChars = listOf('A', 'B', 'C', 'D', 'E', 'F')

            for (i in 0 until str.length) {
                val ch = str[i]

                if (i == 0 && ch !in validChars) break

                if (ch == 'A' && lastChar !in validChars) break

                if (ch == 'F' && lastChar !in listOf('A', 'F')) break

                if (ch == 'C' && lastChar !in listOf('C', 'F')) break

                if (i == str.length - 1 && ch !in validChars) break

                lastChar = ch
                if (i == str.length - 1) isPattern = true
            }

            answer.append(if (isPattern) "Infected!\n" else "Good\n")
        }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`9342`().solution())

    flush()
    close()
}