# Movie Rental

## Part 1

Design and implement a movie rental service. 
Limit yourself to the following classes: `Movie`, `Rental`, `Customer`, `RentalStoreService` 
and `RentalApplication.`

Think about how objects of these classes should work together.
In the end, you should use and execute the ``RentalApplication`` to launch your rental application 
to let a customer rent 3 movies. 

### Movie 
`Movie`- represents a movie, part of the domain.
  - State: title, price, genre (and maybe other...)
    
### Rental
 Rental` - represents a rental, part of the domain. 
- **FYI:** Defining and using a `Rental` class is important. Storing rental-specific 
    information in `Movie` would be a mistake!
- State: returnDate, movie, customer (and maybe other...) 

### Customer
`Customer` - represents a customer, part of the domain.
    - State: name, birthday, age (and maybe other...)
    
### RentalStoreService
`RentalStoreService` - offers methods to rent a movie, get all movies, get customers,...
- State: all customers, all movies, all rentals (and maybe other...)
- (Let's say there's a max. limit of 5 customers, 10 movies and 20 rentals)

The name **Service** has a meaning. Services often offer specific 'services' (specific methods) to other classes. 
In this case, our `RentalStoreService` should offer the services to (e.g.) rent a movie, get all movies, create a customer 
and other.

### RentalApplication
 `RentalApplication` - offers a CLI and interacts with a `RentalStoreService`object 
 to (e.g.) rent a movie.

## Part 2

First completely finish part 1.

Two additional requirements are made by our client (the owner of the rental store):
1. Movies have a fixed price and return date based on a specific criteria.
2. Movies should be able to be downgraded (this is related to the first requirement).

### Requirement 1

Movies have a fixed price based on how relevant the movies are:
- One-day movies: you should return them the next day, their price is 5 euro.
- Trending movies: you should return them within a week, their price is 3 euro.
- Older movies: you should return them within a week, their price is 1 euro.

### Requirement 2
Make it possible to 'downgrade' a movie: One-day movies > trending movies > older movies.
- Downgrading a one-day movie makes it a trending movie
- Downgrading a trending movie makes it a older movie
- Downgrading a older movie makes it a older movie