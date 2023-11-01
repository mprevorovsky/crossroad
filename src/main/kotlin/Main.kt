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
    // update timers, schedule car arrival events
    roads.forEach {
        it.update()
    }

    println()
    printRoads()
    printEventQueue()

    // decrements queue timers, handle due events
    eventQueue.forEach {
        it.timeToExecution -= 1
        if (it.timeToExecution == 0) {
            it.performEventActions()
        }
    }

    // remove handled events, add any newly created events
    eventQueue.removeAll { it.timeToExecution == 0 }
    eventQueue.addAll(newEvents)
    eventQueue.sortBy { it.timeToExecution }
    newEvents.clear()

    Thread.sleep(1000)
}
