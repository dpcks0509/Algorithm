package data_structure

class `14425` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        val targets = mutableSetOf<String>()
        repeat(n) {
            targets.add(readLine())
        }

        val strings = mutableListOf<String>()
        repeat(m) {
            strings.add(readLine())
        }

        val answer = strings.count { targets.contains(it) }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`14425`().solution())

    flush()
    close()
}