import java.util.LinkedList

/*
* FIFO queue of scheduled events that are to happen at the crossroad.
 */
class Queue {
    val events = LinkedList<Event>()

    // new events will be placed at the end of the queue
    fun addEvent(event: Event) {}

    // since this is a FIFO queue, we will always remove the very first (oldest) event in the queue
    fun removeEvent() {}
}