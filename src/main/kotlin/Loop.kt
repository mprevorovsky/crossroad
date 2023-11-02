/**
 * Main loop of the crossroad simulation.
 */
fun runLoop() {
    if (VERBOSE_RUN) {
        println()
        printRoads()
        printEventQueue()
    }

    // crossroad: update timers, schedule car arrival events
    roads.forEach { it.update() }

    // event queue: decrement queue timers, handle due events
    eventQueue.forEach {
        it.timeToExecution -= 1
        if (it.timeToExecution == 0) {
            it.performEventActions()
        }
    }

    // event queue: remove handled events, add any newly created events, sort
    eventQueue.removeAll { it.timeToExecution == 0 }
    eventQueue.addAll(newEvents)
    eventQueue.sortBy { it.timeToExecution }
    newEvents.clear()

    Thread.sleep(LOOP_INTERVAL_TIME)
}