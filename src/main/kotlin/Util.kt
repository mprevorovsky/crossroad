/* A function used to create and initialize the crossroad
 */
fun createCrossroad(): List<Road> {
    return listOf(
        Road(
            direction = "North", carsArrivingPerMinute = carsArrivingPerMinuteNorth,
        ),

        Road(
            direction = "South", carsArrivingPerMinute = carsArrivingPerMinuteSouth,
        ),

        Road(
            direction = "West", carsArrivingPerMinute = carsArrivingPerMinuteWest,
        ),

        Road(
            direction = "East", carsArrivingPerMinute = carsArrivingPerMinuteEast,
        )
    )
}