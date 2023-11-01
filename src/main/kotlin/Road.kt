data class Road(
    val direction: String,
    val carsArrivingPerMinute: Int,
    val departureDuration: Int = carDepartureDuration,
    val isNorthSouth: Boolean
) {
    val arrivalDuration: Int = 60 / carsArrivingPerMinute
    var arrivalTimer: Int = arrivalDuration
    var departureTimer: Int = departureDuration
    var carsWaiting: Int = 0

    fun update() {
        if (arrivalTimer == 0) {
            carsWaiting += 1
            arrivalTimer = arrivalDuration
        }
        arrivalTimer -= 1

        if (isNorthSouth == lights.isNorthLightGreen && carsWaiting > 0) {
            if (departureTimer == 0) {
                carsWaiting -= 1
                departureTimer = departureDuration
            }
            departureTimer -= 1
        }
    }
}
