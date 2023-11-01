/**
 * Scheduled drive of a car through the crossroad.
 *
 * The event is associated with a particular incoming direction of the crossroad.
 * Upon handling of the event, the car is simply removed from the carsWaiting counter of the
 * corresponding Road object.
 */
class CarDepartureEvent(
    override var timeToExecution: Int,
    val direction: Directions
) : Event {

    override fun performEventActions() {
        roads.find { it.direction == direction }!!.carsWaiting -= 1

        println("a car departed from $direction")
    }


    override fun toString(): String {
        return "CarDepartureEvent(direction=$direction, timer=$timeToExecution)"
    }
}