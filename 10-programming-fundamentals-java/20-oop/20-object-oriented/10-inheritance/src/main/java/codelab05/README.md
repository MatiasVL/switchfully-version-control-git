# Movie Rental V2

If you didn't do Codelab08 from classes, do this first:

Design and implement a movie renting service. 
Limit yourself to classes:
 - Movie (title, price, genre), 
 - Rental (returnDate, movie, customer), 
 - Customer (name, birthday, age)
 - RentalService (customers, movies).

A rental movie has different types:
- 1 day movies: you should return it the next day, the price is 5 euro.
- trending movies: you should return it within a week, the price is 3 euro.
- older movies: you should return it within a week, the price is 1 euro.

Make it possible to downgrade (1 day movies > trending movies > older movies) each movie in the RentalService.