fun main() {
    val eventQueue = mutableListOf<Event>()

    val roads = createCrossroad()

        runLoop(roads, eventQueue)
}


fun runLoop(roads: Collection<Road>, eventQueue: MutableList<Event>) {
    roads.forEach {
        it.updateTimers()
    }

    updateEventQueue(eventQueue)
}


fun updateEventQueue(eventQueue: MutableList<Event>) {
    eventQueue.forEach { it.decrementTimeToExecution() }
    
    while (eventQueue.first().timeToExecution == 0) {
        eventQueue.first().performActions()
        eventQueue.removeFirst()
    }
}


