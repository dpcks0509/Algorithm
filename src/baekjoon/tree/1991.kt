package baekjoon.tree

fun main() {
    data class Node(
        val value: String,
        var left: Node? = null,
        var right: Node? = null,
    )

    val n = readln().toInt()

    val tree = mutableMapOf<String, Node>()

    for (i in 0 until n) {
        val value = ('A' + i).toString()
        tree[value] = Node(value)
    }

    repeat(n) {
        val (value, left, right) = readln().split(" ")
        val node = tree[value]!!
        node.left = if (left != ".") tree[left] else null
        node.right = if (right != ".") tree[right] else null
    }

    fun preOrder(node: Node?) {
        if (node == null) return

        print(node.value)
        preOrder(node.left)
        preOrder(node.right)
    }

    fun inOrder(node: Node?) {
        if (node == null) return

        inOrder(node.left)
        print(node.value)
        inOrder(node.right)
    }

    fun postOrder(node: Node?) {
        if (node == null) return

        postOrder(node.left)
        postOrder(node.right)
        print(node.value)
    }

    preOrder(tree["A"])
    println()

    inOrder(tree["A"])
    println()

    postOrder(tree["A"])
}
