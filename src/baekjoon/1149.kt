package baekjoon

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()

    val homes = Array(n) { br.readLine().split(' ').map { it.toInt() } }

    val dpR = IntArray(n)
    val dpG = IntArray(n)
    val dpB = IntArray(n)

    dpR[0] = homes[0][0]
    dpG[0] = homes[0][1]
    dpB[0] = homes[0][2]

    for (i in 1 until n) {
        dpR[i] = minOf(dpG[i - 1], dpB[i - 1]) + homes[i][0]
        dpG[i] = minOf(dpR[i - 1], dpB[i - 1]) + homes[i][1]
        dpB[i] = minOf(dpR[i - 1], dpG[i - 1]) + homes[i][2]
    }

    val min = listOf(dpR[n - 1], dpG[n - 1], dpB[n - 1]).minOf { it }

    bw.write("$min")
    bw.flush()
}
