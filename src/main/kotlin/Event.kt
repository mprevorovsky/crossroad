/**
 * A common interface for various traffic events that can be scheduled in the event queue.
 *
 * Each event has a scheduled time for execution/handling (used as a countdown timer).
 * Upon being handled, events can perform various actions (such as creation of new events,
 * modification of other objects, etc.).
 */
interface Event {
    var timeToExecution: Int

    fun performEventActions()
}