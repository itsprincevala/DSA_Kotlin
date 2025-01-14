package basic_data_structure

class Queue<T> {

    internal data class Node<T>(val value: T, var next: Node<T>?)

    private var front: Node<T>? = null
    private var rear: Node<T>? = null
    private var size: Int = 0

    fun enqueue(value: T) {
        val newNode = Node(value, null)
        rear?.let {
            it.next = newNode
        }
        rear = newNode
        if(front == null)
            front = rear
        size ++
    }

    fun dequeue(): T? {
        val dequeuedValue = front?.value
        front = front?.next
        if(front == null)
            rear = null
        size--
        return dequeuedValue
    }

    fun peek(): T? {
        return front?.value
    }

    fun size(): Int = size

}

fun main() {
    val queue = Queue<Int>()
    println("Queue size: ${queue.size()}")
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(4)
    queue.enqueue(8)
    println("Queue size: ${queue.size()}")
    println("Queue dequeue: ${queue.dequeue()}")
    println("Queue peek: ${queue.peek()}")
}