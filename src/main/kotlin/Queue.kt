import java.util.LinkedList

/*
* FIFO queue of scheduled events that are to happen at the crossroad.
 */
data class Queue(
    var events: MutableList<Event> = mutableListOf()
) {
    // new events will be placed at the end of the queue
    fun addEvent(event: Event) {
        TODO("Not yet implemented")
    }

    // since this is a FIFO queue, we will always remove the very first (oldest) event in the queue
    fun removeEvent() {
        TODO("Not yet implemented")
    }
}