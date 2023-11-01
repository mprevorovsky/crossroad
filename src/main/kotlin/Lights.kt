data class Lights (
    val nsGreenDuration: Int = northSouthGreenDuration,
    val weGreenDuration: Int = westEastGreenDuration,
    var isNorthLightGreen: Boolean = true,
    var timeToLightSwitch: Int = northSouthGreenDuration,
) {
    fun update() {
        if (timeToLightSwitch == 0) {
            timeToLightSwitch = if (isNorthLightGreen) weGreenDuration else nsGreenDuration

            roads.forEach {
                if (it.isNorthSouth == isNorthLightGreen) it.departureTimer = 0
            }
            isNorthLightGreen = !isNorthLightGreen


        }
        else timeToLightSwitch -= 1
    }
}