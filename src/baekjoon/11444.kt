package baekjoon

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val num = br.readLine().toLong()
    val origin = arrayOf(longArrayOf(1L, 1L), longArrayOf(1L, 0L))

    bw.write("${power(origin, num-1)[0][0]}")
    bw.flush()
    bw.close()
    br.close()
}

fun multi(st: Array<LongArray>, origin: Array<LongArray>): Array<LongArray> {
    val tmp = Array(2) { LongArray(2) }
    for (i in 0 until 2) {
        for (j in 0 until 2) {
            for (k in 0 until 2) {
                tmp[i][j] += st[i][k] * origin[k][j]
            }
            tmp[i][j] %= 1000000007L
        }
    }
    return tmp
}

fun power(mat: Array<LongArray>, exponent: Long): Array<LongArray> {
    return when(exponent) {
        0L, 1L -> mat
        else -> {
            val n = power(mat, exponent / 2)

            if (exponent % 2 == 0L) multi(n, n)
            else multi(multi(n, n), mat)
        }
    }
}