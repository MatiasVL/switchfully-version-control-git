# Football (as in "soccer")

## Footballer
A footballer has the following state
- A name
- A Birthday (as LocalDate)
- A shirtNumber (String or int?)
    - Tip: Will we ever do calculations with shirtNumber?
- The number of goals scored
- A Position
    - There a 4 positions:
        - GOALKEEPER
        - DEFENDER
        - MIDFIELDER
        - STRIKER

## FootballTeam
A FootballTeam has to following state
- Footballers (max allowed amount: 11)

A FootballTeam has the following behavior
- A method returning the list of footballers (in their natural order, which is based on the birthday, descending)
- A method returning the list of footballers sorted by their shirt number (ascending)
- A method returning the list of footballers sorted by their position
    - Starting from index 0: Midfielders -> Defenders -> Goalkeepers -> Strikers