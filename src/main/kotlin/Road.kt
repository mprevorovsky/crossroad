data class Road(
    val carsArrivingPerMinute: Int,
    val direction: Directions,
) {
    val isNorthSouth: Boolean = direction in listOf(Directions.NORTH, Directions.SOUTH)
    val arrivalInterval: Int = 60 / carsArrivingPerMinute
    var arrivalTimer: Int = arrivalInterval
    var carsWaiting: Int = 0

    fun update() {
        arrivalTimer -= 1
        if (arrivalTimer == 0) {
            eventQueue.add(CarArrivalEvent(direction = direction))
            arrivalTimer = arrivalInterval
        }
    }
}
