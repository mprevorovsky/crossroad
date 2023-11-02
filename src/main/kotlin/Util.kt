/**
 * Creates and initializes the crossroad.
 */
fun createCrossroad(): List<Road> {
    return listOf(
        Road(carsArrivingPerMinute = CARS_ARRIVING_PER_MINUTE_NORTH, direction = Directions.NORTH),
        Road(carsArrivingPerMinute = CARS_ARRIVING_PER_MINUTE_SOUTH, direction = Directions.SOUTH),
        Road(carsArrivingPerMinute = CARS_ARRIVING_PER_MINUTE_WEST, direction = Directions.WEST),
        Road(carsArrivingPerMinute = CARS_ARRIVING_PER_MINUTE_EAST, direction = Directions.EAST)
    )
}


/**
 *  Prints the current state of the crossroad.
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
 */
fun printEventQueue() {
    eventQueue.forEach { println(it) }
    println("---")
}