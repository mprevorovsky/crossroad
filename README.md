# Crossroad simulation

## Problem specification

The aim is to simulate the functioning of a simple cross-shaped intersection of 4 roads coming from north, south, west and east.

Properties of the system:
- There is a simple red-green traffic light at each road.
- Green interval durations are set independently for each route (pair of directions): NORTH-SOUTH (X1) and WEST-EAST (X2). Only one route is active (green) at any given time. 
- each road has its specific rate of incoming cars per minute (A1, A2, A3, A4)
- It takes S1 seconds for a car to drive through the crossroad (always following a straight route).

No other properties, behaviour or components are taken into account for simplicity.

## Design of solution

The system consists of the following objects that interact with each other and are dynamically updated as time passes:
- Crossroad
- Traffic Lights
- Queue of various scheduled Events (car arrival/departure, switching of lights)

The whole system runs in a loop (discrete-simulation style) and is controlled by count-down timers embedded in the individual components of the system. 
The timers are updated (decremented or reset) in each cycle of the loop.
When a timer runs out, an action is triggered: e.g. component state is updated, scheduled event is handled and removed from the queue, new event is scheduled.
When an event is handled, actions specific for the given event type are performed.

### Events

#### Event

    interface Event(timeToExecution: Int)
        fun performEventActions()
    

A common interface for various traffic events that can be scheduled in the event queue.

#### LightSwitchEvent

    class LightSwitchEvent(timeToExecution: Int) : Event 
        fun performEventActions()
            - switch the traffic Lights
            - schedule CarDepartureEvents
            - schedule next LightSwitchEvent

The duration of the current "green" interval (i.e. the timeToExecution of the newly created LightSwitchEvent) is specific for the NORTH-SOUTH (X1) vs WEST-EAST (X2) routes.

The maximum number of newly scheduled CarDepartureEvents is limited by the number of available cars waiting at each Road of the "green" route and by the duration of the "green" interval (interval duration divided by the S1 time required for one car to drive through the crossroad). 

#### CarArrivalEvent

     class CarArrivalEvent(timeToExecution: Int, direction: NORTH|SOUTH|WEST|EAST) : Event 
        fun performEventActions()
            - schedule one CarDepartureEvent or keep car waiting

If traffic rules and conditions allow (the given route is "green", there is enough time left in the current lights interval taking into account cars already scheduled to depart), the arriving car is immediately scheduled for departure (a CarDepartureEvent is created).

Otherwise the car is kept waiting by incremented the carsWaiting property of the corresponding Road object.

#### CarDepartureEvent

     class CarDepartureEvent(timeToExecution: Int, direction: NORTH|SOUTH|WEST|EAST) : Event 
        fun performEventActions()
            - remove car from the system

The carsWaiting property of the corresponding Road object is decremented.

### Queue

    class eventQueue : mutableCollectionOf<Event>

The eventQueue component is modelled as a mutable collection of Events.

### Lights

    class Lights (isNorthLightGreen: Boolean)
        fun switch()
            - flip isNorthLightGreen property

Lights keep the state of the traffic light system by indicating which route is currently "green".

### Crossroad

#### Road

    class Road(carsArrivingPerMinute: Int, direction: NORTH|SOUTH|WEST|EAST, arrivalTimer: Int, carsWaiting: Int)
        fun update()
            - decrement arrivalTimer
            - when arrivalTimer runs out, reset it and schedule a new CarArrivalEvent

Each Road stores information on its direction, specific rate of incoming cars, the number of cars currently waiting here, and a count-down timer towards the next arrival of a new car.

#### Crossroad

    class Crossroad : Collection<Road>

The Crossroad is modelled as a collection of 4 individual Roads.

## Implementation notes

Application settings, together with all parameters specifying the dynamics of the simulated crossroad are stored as constants in the Configuration.kt file.

The eventQueue is initialized with a single LightsSwitchEvent.

The runLoop() function periodically updates all timers and handles any events due in the eventQueue.
To mimic the passage of time, a sleep interval of duration LOOP_INTERVAL_TIME is included in the runLoop() function.

As default, the application prints out in each loop cycle the state of the Lights, Crossroad, eventQueue and any event-triggered messages. 
This behaviour can be disabled by setting VERBOSE_RUN to false.