package baekjoon.data_structure

class `1620` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val answer = StringBuilder()

        val (n, m) = readLine().split(" ").map { it.toInt() }
        val nameKeyHashMap = HashMap<String, Int>()
        val numberKeyHashMap = HashMap<Int, String>()
        for (i in 1..n) {
            val name = readLine()
            nameKeyHashMap[name] = i
            numberKeyHashMap[i] = name
        }

        repeat(m) {
            val target = readLine()

            if (target[0].isDigit()) {
                val num = target.toInt()
                answer.append("${numberKeyHashMap[num]}\n")
            } else {
                answer.append("${nameKeyHashMap[target]}\n")
            }
        }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`1620`().solution())

    flush()
    close()
}