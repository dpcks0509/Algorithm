package tony.string

import java.util.TreeMap

class `20291` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val answer = StringBuilder()

        val n = readLine().toInt()
        val treeMap = TreeMap<String, Int>()
        repeat(n) {
            val input = readLine().split(".")
            val extension = input[1]
            treeMap[extension] = treeMap.getOrDefault(extension, 0) + 1
        }
        treeMap.forEach { answer.append("${it.key} ${it.value}\n") }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`20291`().solution())

    flush()
    close()
}