/*
* constants defined in the assignment were given more descriptive names
*
* time (duration) is expressed in seconds (but any arbitrary discrete units would do)
 */

// X1
const val northSouthGreenDuration: Int = 30
// X2
const val westEastGreenDuration: Int = 40

// S1
const val carDepartureDuration: Int = 3

// A1
const val carsArrivingPerMinuteNorth: Int = 10
// A2
const val carsArrivingPerMinuteSouth: Int = 10
// A3
const val carsArrivingPerMinuteWest: Int = 12
// A4
const val carsArrivingPerMinuteEast: Int = 12


var isNorthLightGreen = true
var timeToLightSwitch = northSouthGreenDuration


/* A function used to create and initialize the crossroad
 */
fun createCrossroad() : List<Road> {
    return listOf(
        Road(
            direction = "North",
            isGreen = isNorthLightGreen,
            carsArrivingPerMinute = carsArrivingPerMinuteNorth,
            greenDuration = northSouthGreenDuration
        ),

        Road(
            direction = "South",
            isGreen = isNorthLightGreen,
            carsArrivingPerMinute = carsArrivingPerMinuteSouth,
            greenDuration = northSouthGreenDuration
        ),

        Road(
            direction = "West",
            isGreen = !isNorthLightGreen,
            carsArrivingPerMinute = carsArrivingPerMinuteWest,
            greenDuration = westEastGreenDuration
        ),

        Road(
            direction = "East",
            isGreen = !isNorthLightGreen,
            carsArrivingPerMinute = carsArrivingPerMinuteEast,
            greenDuration = westEastGreenDuration
        )
    )
}