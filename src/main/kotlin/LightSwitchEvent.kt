class LightSwitchEvent(override var timeToExecution: Int) : Event {
    override fun performEventActions() {
        newEvents.add(LightSwitchEvent(getCycleDuration()))
        lights.switch()

        // TODO
        // schedule CarDepartureEvents based on available "green" time and the number of waiting cars
    }

    fun getCycleDuration(): Int {
        return if (lights.isNorthLightGreen) westEastGreenDuration else northSouthGreenDuration
    }
}