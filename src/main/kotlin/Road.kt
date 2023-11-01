data class Road(
    val direction: String,
    var isGreen: Boolean,
    val greenDuration: Int,
    var remainingGreenTime: Int = greenDuration,
    val carsArrivingPerMinute: Int,
    var timeToCarArrival: Int = 60 / carsArrivingPerMinute,
    var carsWaiting: Int = 0
) {

    fun updateTimers() {
        if (this.isGreen) {
            this.remainingGreenTime -= 1
        }

        if (this.timeToCarArrival == 0) {
            this.timeToCarArrival = 60 / carsArrivingPerMinute
        }
        else {
            timeToCarArrival -= 1
        }
    }

    fun updateLights() {
        if (this.remainingGreenTime) == 0 {
            isGreen =
        }
    }
}
