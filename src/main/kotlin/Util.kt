/**
 * Creates and initializes the crossroad as a Map of 4 Road objects (1 for each incoming direction).
 */
fun createCrossroad(): List<Road> {
    return listOf(
        Road(carsArrivingPerMinute = carsArrivingPerMinuteNorth, direction = Directions.NORTH),
        Road(carsArrivingPerMinute = carsArrivingPerMinuteSouth, direction = Directions.SOUTH),
        Road(carsArrivingPerMinute = carsArrivingPerMinuteWest, direction = Directions.WEST),
        Road(carsArrivingPerMinute = carsArrivingPerMinuteEast, direction = Directions.EAST)
    )
}


fun printRoads() {
    roads.forEach {
        println("$it arrivalTimer ${it.arrivalTimer} carsWaiting ${it.carsWaiting} isNS ${it.isNorthSouth}")
    }
}


fun printEventQueue() {
    eventQueue.forEach {
        println("$it timer ${it.timeToExecution} NS lights on: ${lights.isNorthLightGreen}")
    }

}