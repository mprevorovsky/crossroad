/**
 * Constants defined in the assignment that describe main properties of the simulated system.
 *
 * Time (duration) is expressed in seconds (but any discrete numeric units would work).
 */
// X1
const val NORTH_SOUTH_GREEN_DURATION: Int = 10
// X2
const val WEST_EAST_GREEN_DURATION: Int = 12
// S1
const val CAR_DEPARTURE_DURATION: Int = 2
// A1
const val CARS_ARRIVING_PER_MINUTE_NORTH: Int = 12
// A2
const val CARS_ARRIVING_PER_MINUTE_SOUTH: Int = 12
// A3
const val CARS_ARRIVING_PER_MINUTE_WEST: Int = 16
// A4
const val CARS_ARRIVING_PER_MINUTE_EAST: Int = 16


/**
 *  Application settings.
 */
// should print out the state of the system in each loop cycle?
const val VERBOSE_RUN: Boolean = true

// sleep time of each main loop cycle (in milliseconds)
const val LOOP_INTERVAL_TIME: Long = 1000
