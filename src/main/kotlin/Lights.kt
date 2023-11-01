data class Lights (
    val nsGreenDuration: Int = northSouthGreenDuration,
    val weGreenDuration: Int = westEastGreenDuration,
    var isNorthLightGreen: Boolean = true,
    var timeToLightSwitch: Int = northSouthGreenDuration,
) {
    fun update() {
        if (timeToLightSwitch == 0) {
            timeToLightSwitch = if (isNorthLightGreen) weGreenDuration else nsGreenDuration
            isNorthLightGreen = !isNorthLightGreen
        }
        else timeToLightSwitch -= 1
    }
}