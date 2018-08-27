# Harry Potter Book Discount

Although the code works, there are some code smells present.

The tests serve as the documentation, so study them closely.

- Make sure you understand the code!
- Find and refactor the code smells!
- Run the tests, make sure the tests still work afterwards
    - Refactor the tests if needed
    
## Some written documentation    

One copy of any of the five Harry Potter books (We are not selling the final two books) costs 8 EUR.

- If you buy 2 different books in the series, you get a 5% discount on the total sum.
- If you buy 3 different books in the series, you get a 10% discount on the total sum.
- If you buy 4 different books in the series, you get a 20% discount on the total sum.
- If you buy all 5 books in the series, you get a 25% discount.

Pay attention though:

- If you buy (e.g.) four books, of which 3 are different books in the series (they make a set), 
you get a 10% discount on that set.
The fourth book (which is a duplicate of one of the other 3) still costs 8 EUR.
- If you buy multiple books, that make multiple sets,
you only get a discount on your first set.
For example: you buy 2 copies of the first book, 2 copies of the second book. Thus, you bought 2 sets (each set containing the first book and the second). 
You only get a discount (of 5%) on the first set. The total sum will be 31.2 EUR. (15.2 + 16)