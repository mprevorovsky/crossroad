val lights = Lights()
val roads = createCrossroad()
val eventQueue = mutableListOf<Event>(
    LightSwitchEvent(1),
)
val newEvents = mutableListOf<Event>()

fun main() {
    while (true) runLoop()
}


fun runLoop() {
    println()
    //printLights()
    //printRoads()
    printEventQueue()

    roads.forEach {
        it.value.update()
    }

    // decrements timers, handle current events
    eventQueue.forEach {
        it.timeToExecution -= 1
        if (it.timeToExecution == 0) {
            it.performEventActions()
        }
    }

    // remove handled events, add newly created events
    eventQueue.removeAll { it.timeToExecution == 0 }
    eventQueue.addAll(newEvents)
    eventQueue.sortBy { it.timeToExecution }
    newEvents.clear()

    Thread.sleep(1000)
}
