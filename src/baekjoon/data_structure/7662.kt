package baekjoon.data_structure

import java.util.TreeMap

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val treeMap = TreeMap<Int, Int>()

        val k = readln().toInt()

        repeat(k) {
            val (cmd, num) = readln().split(" ")
            val n = num.toInt()

            when (cmd) {
                "I" -> {
                    treeMap[n] = treeMap.getOrDefault(n, 0) + 1
                }

                "D" -> {
                    if (treeMap.isNotEmpty()) {
                        if (n == 1) {
                            val max = treeMap.lastKey()

                            if (treeMap[max] == 1) {
                                treeMap.remove(max)
                            } else {
                                treeMap[max] = treeMap[max]!! - 1
                            }
                        } else if (n == -1) {
                            val min = treeMap.firstKey()

                            if (treeMap[min] == 1) {
                                treeMap.remove(min)
                            } else {
                                treeMap[min] = treeMap[min]!! - 1
                            }
                        }
                    }
                }
            }
        }

        if (treeMap.isNotEmpty()) {
            val max = treeMap.lastKey()
            val min = treeMap.firstKey()
            println("$max $min")
        } else {
            println("EMPTY")
        }
    }
}
