/**
 * Scheduled switching of the traffic lights.
 *
 * The event
 * - generates a future LightSwitchEvent to set green light on in the other traffic direction
 * - terminates the current cycle by switching the traffic lights
 * - schedules waiting cars (if there are any) for departure in the freshly started cycle;
 * -- this is limited to roads with green traffic light signal
 * -- the number of scheduled cars is limited by cycle duration.
 */
class LightSwitchEvent(
    override var timeToExecution: Int
) : Event {

    override fun performEventActions() {
        newEvents.add(LightSwitchEvent(getCycleDuration()))
        lights.switch()
        scheduleCarDepartureEvents()

        if (VERBOSE_RUN) println("scheduled light cycle switch")
    }


    private fun getCycleDuration(): Int {
        return if (lights.isNorthLightGreen) WEST_EAST_GREEN_DURATION else NORTH_SOUTH_GREEN_DURATION
    }


    private fun scheduleCarDepartureEvents() {
        val activeRoads = if (lights.isNorthLightGreen) roads.filter { it.isNorthSouth } else roads.filterNot { it.isNorthSouth }

        val greenInterval = if (lights.isNorthLightGreen) NORTH_SOUTH_GREEN_DURATION else WEST_EAST_GREEN_DURATION

        activeRoads.forEach {
            val eventsToSchedule = minOf(greenInterval / CAR_DEPARTURE_DURATION, it.carsWaiting)

            if (eventsToSchedule == 0) return@forEach
            for (i in 1..eventsToSchedule) {
                newEvents.add(CarDepartureEvent(direction = it.direction, timeToExecution = 1 + (i - 1) * CAR_DEPARTURE_DURATION))
            }

            if (VERBOSE_RUN) println("scheduled $eventsToSchedule car(s) from ${it.direction}")
        }
    }


    override fun toString(): String {
        return "LightSwitchEvent(timer=$timeToExecution)"
    }
}