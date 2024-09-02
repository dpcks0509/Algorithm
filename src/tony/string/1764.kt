package tony.string

class `1764` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val answer = StringBuilder()

        val (n, m) = readLine().split(" ").map { it.toInt() }
        val neverHeardPeoples = mutableSetOf<String>()
        val neverHeardAndSeenPeoples = mutableSetOf<String>()

        repeat(n) {
            neverHeardPeoples.add(readLine())
        }
        repeat(m) {
            val neverSeenPeople = readLine()
            if (neverHeardPeoples.contains(neverSeenPeople)) neverHeardAndSeenPeoples.add(neverSeenPeople)
        }

        answer.append("${neverHeardAndSeenPeoples.size}\n")
        neverHeardAndSeenPeoples.sorted().forEach { answer.append("${it}\n") }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`1764`().solution())

    flush()
    close()
}