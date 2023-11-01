val lights = Lights()
val roads = createCrossroad()

fun main() {
    while (true) runLoop()
}


fun runLoop() {
    roads.forEach {
        it.update()
    }
    lights.update()

    println()
    printLights()
    printRoads()

    Thread.sleep(1000)
}
