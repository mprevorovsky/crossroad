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


/**
 *  Prints the current state of the crossroad.
 *
 *  A helper function for debugging.
 */
fun printRoads() {
    roads.forEach {
        println("$it arrivalTimer ${it.arrivalTimer} carsWaiting ${it.carsWaiting} " +
                "NS_lights: ${lights.isNorthLightGreen} WE_lights: ${!lights.isNorthLightGreen}")
    }
    println("---")
}


/**
 * Prints the current state of the event queue.
 *
 * A helper function for debugging.
 */
fun printEventQueue() {
    eventQueue.forEach { println(it) }
    println("---")
}