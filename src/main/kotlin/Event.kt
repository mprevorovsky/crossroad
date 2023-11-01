interface Event {
    var timeToExecution: Int

    fun decrementTimeToExecution()

    fun performActions()
}


class LightsSwitch(override var timeToExecution: Int) : Event {
    override fun decrementTimeToExecution() {
        timeToExecution -= 1
    }

    override fun performActions() {
        TODO("Not yet implemented")
    }
}