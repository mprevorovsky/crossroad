/**
 * Event of a new car just coming to the crossroad.
 *
 * The event is associated with a particular incoming direction of the crossroad.
 * Upon handling, the car is either scheduled for departure (a new CarDepartureEvent is created)
 * or kept waiting by incrementing the carsWaiting counter of the corresponding Road object.
 */
class CarArrivalEvent(
    override var timeToExecution: Int = 1,
    val direction: Directions
) : Event {

    override fun performEventActions() {
        //TODO("Not yet implemented")
    // if green light is on && there is enough time before lights switch && the queue for this round is not already full
    //      then schedule a CarDepartureEvent
    // else just increment the carsWaiting counter of the respective Road object
    }
}