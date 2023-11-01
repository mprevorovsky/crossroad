/**
 * Creates and initializes the crossroad as a Map of 4 Road objects (1 for each incoming direction).
 */
fun createCrossroad(): Map<Directions, Road> {
    return mapOf(
        Directions.NORTH to Road(carsArrivingPerMinute = carsArrivingPerMinuteNorth, isNorthSouth = true),
        Directions.SOUTH to Road(carsArrivingPerMinute = carsArrivingPerMinuteSouth, isNorthSouth = true),
        Directions.WEST to Road(carsArrivingPerMinute = carsArrivingPerMinuteWest, isNorthSouth = false),
        Directions.EAST to Road(carsArrivingPerMinute = carsArrivingPerMinuteEast, isNorthSouth = false)
    )
}


fun printLights() {
    println("NS green ${lights.isNorthLightGreen}")
}


fun printRoads() {
    roads.forEach {
        println("${it.key} arr ${it.value.arrivalTimer} cars ${it.value.carsWaiting}")
    }
}


fun printEventQueue() {
    eventQueue.forEach {
        println("$it timer ${it.timeToExecution}  NS lights on: ${lights.isNorthLightGreen}")
    }

}