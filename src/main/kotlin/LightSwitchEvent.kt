/**
 * Scheduled switching of the traffic lights.
 *
 * The event generates
 * - generates a future LightSwitchEvent with inverse regulatory effect
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

        println("scheduled light cycle switch")
    }


    private fun getCycleDuration(): Int {
        return if (lights.isNorthLightGreen) westEastGreenDuration else northSouthGreenDuration
    }


    private fun scheduleCarDepartureEvents() {
        val activeRoads = if (lights.isNorthLightGreen) roads.filter { it.isNorthSouth } else roads.filterNot { it.isNorthSouth }

        val greenInterval = if (lights.isNorthLightGreen) northSouthGreenDuration else westEastGreenDuration

        activeRoads.forEach {
            val eventsToSchedule = minOf(greenInterval / carDepartureDuration, it.carsWaiting)

            if (eventsToSchedule == 0) return@forEach
            for (i in 1..eventsToSchedule) {
                newEvents.add(CarDepartureEvent(direction = it.direction, timeToExecution = 1 + (i - 1) * carDepartureDuration))
            }

            println("scheduled $eventsToSchedule car(s) from ${it.direction}")
        }
    }
}