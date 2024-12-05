package baekjoon.data_structure

import java.util.TreeMap

class `4358` {
    fun solution(): String = with(System.`in`.bufferedReader()) {
        val answer = StringBuilder()

        val treeMap = TreeMap<String, Double>()
        var size = 0

        while (true) {
            val name = readLine() ?: break
            treeMap[name] = treeMap.getOrDefault(name, 0.0) + 1.0
            size++
        }

        treeMap.forEach {
            val percentage = (it.value / size) * 100
            answer.append("${it.key} ${String.format("%.4f", percentage)}\n")
        }

        close()
        return answer.toString()
    }
}

fun main(): Unit = with(System.out.bufferedWriter()) {
    write(`4358`().solution())

    flush()
    close()
}