/**
 * Event of a new car just arriving to the crossroad.
 *
 * The event is associated with a particular incoming direction of the crossroad.
 * Upon handling, the car is either scheduled for departure in the current green light cycle,
 * or kept waiting by incrementing the carsWaiting counter of the corresponding Road object.
 */
class CarArrivalEvent(
    override var timeToExecution: Int = 1,
    val direction: Directions
) : Event {

    override fun performEventActions() {
        if (VERBOSE_RUN) println("a car arrived from $direction")

        if (direction in listOf(Directions.NORTH, Directions.SOUTH) == lights.isNorthLightGreen)
            scheduleCarDepartureEvent()

        roads.find { it.direction == direction }!!.carsWaiting += 1
    }


    private fun scheduleCarDepartureEvent(): Boolean {
        val lastScheduledDepartureTime = getLastScheduledDepartureTime()

        if (getRemainingGreenDuration() - lastScheduledDepartureTime >= CAR_DEPARTURE_DURATION) {
            newEvents.add(CarDepartureEvent(
                direction = direction,
                timeToExecution = lastScheduledDepartureTime + CAR_DEPARTURE_DURATION))

            if (VERBOSE_RUN) println("scheduled a car from $direction")
            return true
        }

        return false
    }


    private fun getRemainingGreenDuration(): Int {
        return eventQueue
            .filterIsInstance(LightSwitchEvent::class.java)
            .first()
            .timeToExecution
    }


    private fun getLastScheduledDepartureTime(): Int {
        val carDepartureEvents = eventQueue
            .filterIsInstance(CarDepartureEvent::class.java)
            .filter { it.direction == direction }

        return if (carDepartureEvents.isEmpty()) 0 else carDepartureEvents.last().timeToExecution
    }


    override fun toString(): String {
        return "CarArrivalEvent(direction=$direction, timer=$timeToExecution)"
    }
}