// initialize main components of the simulated system (traffic lights, crossroad with cars, queue of scheduled events)
val lights = Lights()
val roads = createCrossroad()
val eventQueue = mutableListOf<Event>(
    LightSwitchEvent(timeToExecution = 1)
)

// initialize temporary storage for events scheduled in the current loop cycle
val newEvents = mutableListOf<Event>()


fun main() {
    while (true) runLoop()
}
