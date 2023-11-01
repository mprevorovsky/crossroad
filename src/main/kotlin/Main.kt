

fun main() {
    var eventQueue = Queue()

    val p = mutableListOf<Event>()
    p.removeFirst()

    val roads = createCrossroad()

        runLoop(roads, eventQueue)
}


fun runLoop(roads: Collection<Road>, eventQueue: Queue) {
    TODO("Not yet implemented")
}


