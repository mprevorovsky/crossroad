/**
 * Scheduled drive of a car through the crossroad.
 *
 * The event is associated with a particular incoming direction of the crossroad.
 * Upon handling of the event, the carsWaiting counter of the corresponding Road object
 * is decremented.
 */
class CarDepartureEvent(
    override var timeToExecution: Int,
    val direction: Directions
) : Event {

    override fun performEventActions() {
        roads.find { it.direction == direction }!!.carsWaiting -= 1

        if (VERBOSE_RUN) println("a car departed from $direction")
    }


    override fun toString(): String {
        return "CarDepartureEvent(direction=$direction, timer=$timeToExecution)"
    }
}