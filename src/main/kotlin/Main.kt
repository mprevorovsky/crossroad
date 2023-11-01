fun main() {
    val lights = Lights()
    val eventQueue = mutableListOf<Event>()
    val roads = createCrossroad()

    runLoop(roads, eventQueue, lights)
}


fun runLoop(roads: Collection<Road>, eventQueue: MutableList<Event>, lights: Lights) {
    roads.forEach {
        it.update()
    }

    updateEventQueue(eventQueue)
    lights.update()
}


fun updateEventQueue(eventQueue: MutableList<Event>) {
    eventQueue.forEach { it.decrementTimeToExecution() }
    
    while (eventQueue.first().timeToExecution == 0) {
        eventQueue.first().performActions()
        eventQueue.removeFirst()
    }
}
