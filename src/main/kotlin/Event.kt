interface Event {
    fun decrementTimeToExecution()

    fun performActions()
}


class LightsSwitch(var timeToExecution: Int) : Event {
    override fun decrementTimeToExecution() {
        timeToExecution -= 1
    }

    override fun performActions() {
        TODO("Not yet implemented")
    }
}