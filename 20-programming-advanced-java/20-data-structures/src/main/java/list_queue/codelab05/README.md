# Airport watchtower

Create an application in which you can create a WatchTower, Airplanes (with Passengers & Crew) and Runways.

- An Airplane has (at least) following state:
    - Passengers
    - Crew
    - Priority (Enum: LOW, MEDIUM, HIGH)

- A Runway has (at least) following state:
    - Airplanes
    
- A WatchTower has (at least) the following state
    - Runways
    
- A WatchTower has (at least) the following behavior
    - a method nextTakeOff()
        - Given a Runway, it will return the next Airplane on that Runway that can take off.
            - This should be based on the priority of the Airplanes on that Runway.
                - An Airplane with Priority HIGH should always be the first to take of, except if there are other Airplanes with the same priority. 
                    - If there are, it's first come, first serve
                - An Airplane with Priority MEDIUM can only take off if there aren't any Airplanes with priority HIGH
                - An Airplane with Priority LOW can only take off if there aren't any Airplanes with priority MEDIUM or HIGH
                - Tip; we have a great data structure for this...
        - Once an Airplane is returned for takeOff, it should be removed from that Runway