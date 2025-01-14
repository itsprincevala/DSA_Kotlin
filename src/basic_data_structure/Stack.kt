package basic_data_structure

class Stack<T> {

    internal data class Node<T>(val value: T, var previous: Node<T>?)

    private var top: Node<T>? = null
    private var size: Int = 0

    fun push(value: T) {
        val newNode = Node(value, top)
        top = newNode
        size++
    }

    fun pop(): T? {
        return top?.let {
            val poppedValue = it.value
            top = it.previous
            top?.previous = null
            size--
            poppedValue
        }
    }

    fun peek(): T? {
        return top?.value
    }

    fun size(): Int = size

}

fun main() {
    val stack = Stack<Int>()
    println("Stack size: ${stack.size()}")
    stack.push(1)
    stack.push(2)
    stack.push(4)
    stack.push(8)
    println("Stack size: ${stack.size()}")
    println("Stack pop: ${stack.pop()}")
    println("Stack peek: ${stack.peek()}")
    println("Stack size: ${stack.size()}")
}