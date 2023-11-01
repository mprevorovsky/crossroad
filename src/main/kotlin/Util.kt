/* A function used to create and initialize the crossroad
 */
fun createCrossroad(): List<Road> {
    return listOf(
        Road(
            direction = "North", carsArrivingPerMinute = carsArrivingPerMinuteNorth, isNorthSouth = true
        ),

        Road(
            direction = "South", carsArrivingPerMinute = carsArrivingPerMinuteSouth, isNorthSouth = true
        ),

        Road(
            direction = "West", carsArrivingPerMinute = carsArrivingPerMinuteWest, isNorthSouth = false
        ),

        Road(
            direction = "East", carsArrivingPerMinute = carsArrivingPerMinuteEast, isNorthSouth = false
        )
    )
}



fun printLights() {
    println("N green ${lights.isNorthLightGreen} timer ${lights.timeToLightSwitch}")
}



fun printRoads() {
    roads.forEach {
        println("${it.direction} dep ${it.departureTimer} arr ${it.arrivalTimer} cars ${it.carsWaiting}")
    }
}
