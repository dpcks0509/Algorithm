package baekjoon.string

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val p = br.readLine().toCharArray()
        val n = br.readLine().toInt()
        val list =
            br
                .readLine()
                .removeSurrounding("[", "]")
                .split(",")
                .toMutableList()

        fun test(): String {
            var direction = true
            for (ch in p) {
                if (ch == 'R') {
                    if (list.isNotEmpty()) {
                        direction = !direction
                    }
                } else {
                    if (n == 0) return "error"

                    if (list.isNotEmpty()) {
                        if (direction) {
                            list.removeFirst()
                        } else {
                            list.removeLast()
                        }
                    } else {
                        return "error"
                    }
                }
            }

            if (!direction) list.reverse()

            return list.joinToString(",", "[", "]")
        }

        bw.write(test() + "\n")
        bw.flush()
    }
}
