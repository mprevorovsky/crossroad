/**
 * Scheduled drive of a car through the crossroad.
 *
 * The event is associated with a particular incoming direction of the crossroad.
 * Upon handling, the car is simply removed from the carsWaiting counter of the
 * corresponding Road object.
 */
class CarDepartureEvent(
    override var timeToExecution: Int,
    val direction: Directions
) : Event {

    override fun performEventActions() {
        roads[direction]!!.carsWaiting -= 1
    }
}