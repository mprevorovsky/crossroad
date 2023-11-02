/**
 * Holds the state of the traffic light system.
 */
data class Lights (
    var isNorthLightGreen: Boolean = true
) {

    fun switch() {
        isNorthLightGreen = !isNorthLightGreen
    }
}