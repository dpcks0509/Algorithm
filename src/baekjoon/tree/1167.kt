package baekjoon.tree

fun main() {
    data class Node(val value: Int, val distance: Int)

    val v = readln().toInt()

    val tree = Array(v + 1) { mutableListOf<Node>() }

    for (i in 0 until v) {
        val input = readln().split(" ").map { it.toInt() }.toMutableList()
        val parent = input.removeFirst()
        input.removeLast()

        for (j in 0 until input.size / 2) {
            tree[parent].add(Node(input[2 * j], input[2 * j + 1]))
        }
    }

    var max = 0
    val visited = BooleanArray(v + 1)

    fun dfs(n: Int): Int {
        if (tree[n].isEmpty()) return 0

        if (tree[n].size == 1) {
            if (visited[tree[n][0].value]) return 0

            visited[tree[n][0].value] = true
            val sum = tree[n][0].distance + dfs(tree[n][0].value)
            max = maxOf(max, sum)
            return sum
        }

        val list = mutableListOf<Int>()
        for (i in 0 until tree[n].size) {
            if (visited[tree[n][i].value]) continue

            visited[tree[n][i].value] = true
            list.add(tree[n][i].distance + dfs(tree[n][i].value))
        }

        if (list.size == 0) return 0
        if (list.size == 1) {
            max = maxOf(max, list[0])
            return list[0]
        }

        list.sortDescending()
        max = maxOf(max, list[0] + list[1])
        return list[0]
    }

    visited[1] = true
    dfs(1)

    println(max)
}