/**
 * Event of a new car just coming to the crossroad.
 *
 * The event is associated with a particular incoming direction of the crossroad.
 * Upon handling, the car is either scheduled for departure in the current lights cycle
 * (a new CarDepartureEvent is created),
 * or kept waiting by incrementing the carsWaiting counter of the corresponding Road object.
 */
class CarArrivalEvent(
    override var timeToExecution: Int = 1,
    val direction: Directions
) : Event {

    override fun performEventActions() {
        println("a car arrived from $direction")

        if (direction in listOf(Directions.NORTH, Directions.SOUTH) == lights.isNorthLightGreen)
            scheduleCarDepartureEvent()

        roads.find { it.direction == direction }!!.carsWaiting += 1
    }


    private fun scheduleCarDepartureEvent() {
        val lastScheduledDepartureTime = getLastScheduledDepartureTime()

        if (getRemainingCycleDuration() - lastScheduledDepartureTime >= carDepartureDuration) {
            newEvents.add(CarDepartureEvent(
                direction = direction,
                timeToExecution = lastScheduledDepartureTime + carDepartureDuration))

            println("scheduled a car from $direction")
        }
    }


    private fun getRemainingCycleDuration(): Int {
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
}