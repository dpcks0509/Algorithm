package baekjoon.tree

fun main() {
    val n = readln().toInt()

    val tree = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    for (i in 0 until n - 1) {
        val (parent, child, weight) = readln().split(" ").map { it.toInt() }

        tree[parent].add(Pair(child, weight))
    }

    var max = 0

    fun dfs(node: Int): Int {
        if (tree[node].isEmpty()) return 0

        if (tree[node].size == 1) {
            val sum = tree[node][0].second + dfs(tree[node][0].first)
            max = maxOf(max, sum)
            return sum
        }

        val list = mutableListOf<Int>()
        for (i in 0 until tree[node].size) {
            list.add(tree[node][i].second + dfs(tree[node][i].first))
        }
        list.sortDescending()

        max = maxOf(max, list[0] + list[1])
        return list[0]
    }

    dfs(1)

    println(max)
}