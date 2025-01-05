package baekjoon.implementation

import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    val words = Array(n) { br.readLine() }

    var answer = 0
    val target = words[0]
    val targetHashMap = HashMap<Char, Int>()
    target.forEach { ch ->
        targetHashMap[ch] = targetHashMap.getOrDefault(ch, 0) + 1
    }


    for (i in 1 until n) {
        val word = words[i]
        val wordHashMap = HashMap<Char, Int>()
        word.forEach { ch ->
            wordHashMap[ch] = wordHashMap.getOrDefault(ch, 0) + 1
        }

        var difference = 0
        val allChars = targetHashMap.keys + wordHashMap.keys
        for (ch in allChars) {
            difference += abs(targetHashMap.getOrDefault(ch, 0) - wordHashMap.getOrDefault(ch, 0))
        }

        if (difference <= 2 && target.length == word.length || difference == 1 && abs(target.length - word.length) == 1) {
            answer++
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
    br.close()
}