data class Road(
    val direction: String,
    val carsArrivingPerMinute: Int,
    var timeToCarArrival: Int = 60 / carsArrivingPerMinute,
    var carsWaiting: Int = 0
) {

    fun update() {
        if (this.timeToCarArrival == 0) {
            this.addWaitingCar()
            this.timeToCarArrival = 60 / carsArrivingPerMinute
        }
        else {
            timeToCarArrival -= 1
        }
    }

    fun addWaitingCar() {
        this.carsWaiting += 1
    }

    fun removeWaitingCar() {
        this.carsWaiting -= 1
    }
}
