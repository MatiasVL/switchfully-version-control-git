# Sporty sport

Design and implement an application in which we can:

- Create SportTeams (football teams, basketball teams or hockey teams)
- Create SportClubs
- Create Humans which can be one or more Sporters (footballer, basketballer or hockeyer)
    - Different sporters have different behavior (kickBall, tackle, throwBall, dunk, hitPuck, bodySlam)
    
State:
    
- SportClub state
    - multiple SportTeams (fixed number)
    - name (String)
    - foundingYear (java.time.Year)
- SportTeam state
    - multiple members (Sporter) (fixed number)
    - sportclub (SportClub)
    - name (String)
    - description (String)
- Human state
    - name (String)
    - birthdate (java.time.LocalDate)
   
Write a service in which you can create all kinds of sport-clubs, -teams and -humans.
Call this service in an executable class.
    
Be creative and try to create an as good as possible application for the registration of 
humans who want to become sporters and want to join sport-teams and -clubs.

Some food for thought:
- Should a footballer be able to join a basketball team?
- Some humans play football and basketball, your application should allow for this
   
