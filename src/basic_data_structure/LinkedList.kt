package basic_data_structure
data class Node<T>(val data: T, var next: Node<T>? = null)

class LinkedList<T> {

    private var start: Node<T>? = null

    private var last: Node<T>? = null

    fun addStart(value: T) {
        val valueNode = Node(value)
        valueNode.next = start
        start = valueNode
    }

    fun addLast(value: T) {
        val valueNode = Node(value)
        if(start == null)
            start = valueNode
        if(last == null) {
            last = valueNode
        } else {
            last?.next = valueNode
            last = valueNode
        }
    }

    fun deleteStart() {
        start = start?.next
    }

    fun deleteEnd() {
        var currentNode = start
        while (currentNode?.next?.next != null) {
            currentNode = currentNode.next
        }
        currentNode?.next = null
    }

    fun print() {
        var current = start
        print("Linked list: ")
        while (current != null) {
            print("${current.data}, ")
            current = current.next
        }
        println()
    }

}

fun main() {
    val linkedList = LinkedList<Int>()
    linkedList.addLast(1)
    linkedList.addLast(2)
    linkedList.addLast(3)
    linkedList.addLast(4)
    linkedList.addLast(5)
    linkedList.addLast(6)
    linkedList.addLast(7)
    linkedList.addLast(8)
    linkedList.print()
    linkedList.addStart(0)
    linkedList.print()
    linkedList.deleteStart()
    linkedList.deleteStart()
    linkedList.print()
    linkedList.deleteEnd()
    linkedList.print()
}