class LightSwitchEvent(override var timeToExecution: Int) : Event {
    override fun performEventActions() {
        newEvents.add(LightSwitchEvent(getCycleDuration()))
        lights.switch()
        scheduleCarDepartureEvents()
    }


    private fun getCycleDuration(): Int {
        return if (lights.isNorthLightGreen) westEastGreenDuration else northSouthGreenDuration
    }


    private fun scheduleCarDepartureEvents() {
        val activeRoads = if (lights.isNorthLightGreen) roads.filter { it.isNorthSouth } else roads.filterNot { it.isNorthSouth }

        val greenInterval = if (lights.isNorthLightGreen) northSouthGreenDuration else westEastGreenDuration

        activeRoads.forEach {
            val eventToSchedule = minOf(greenInterval / it.arrivalInterval, it.carsWaiting)

            if (eventToSchedule == 0) return@forEach
            for (i in 1..eventToSchedule) {
                newEvents.add(CarDepartureEvent(direction = it.direction, timeToExecution = 1 + (i - 1) * carDepartureDuration))
            }

            //println("scheduled $eventToSchedule car(s) from ${it.direction}")
        }
    }
}