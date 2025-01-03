package baekjoon.implementation

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val ranks = br.readLine().split(" ").map { it.toInt() }

        val teams = IntArray(1001)
        ranks.forEach {
            teams[it] += 1
        }

        var rank = 1
        val scores = Array(1001) { mutableListOf<Int>() }
        ranks.forEach {
            if (teams[it] >= 6) {
                scores[it].add(rank)
                rank += 1
            }
        }

        val sums = scores.map {
            if (it.size >= 6) it.slice(0..3).sum() else Int.MAX_VALUE
        }

        val min = sums.minOrNull()
        val winners = mutableListOf<Int>()
        sums.forEachIndexed { index, sum ->
            if (sum == min) {
                winners.add(index)
            }
        }

        if (winners.size == 1) {
            sb.appendLine(winners[0])
        } else {
            var finalWinner = 0
            var fiveMin = Int.MAX_VALUE
            winners.forEach { winner ->
                if (scores[winner][4] < fiveMin) {
                    fiveMin = scores[winner][4]
                    finalWinner = winner
                }
            }
            sb.appendLine(finalWinner)
        }
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}