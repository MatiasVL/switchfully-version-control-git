# Deck of cards

1. Look at classes Card, Suit and Rank and make sure you understand them. Run all their tests, and fix problems if you find them.
2. Open class Deck. Run its test class, and solve the problems you find.
3. Stay in the Deck class. Come up with a Collection object for the cards instance variable, and replace the Card[] Array with it. The code in the Deck class will break. That is to be expected. We will refactor the object completely in the following steps.
4. Refactor the Deck's default constructor, to use your new cards collection object.
5. Refactor the Deck's other constructor.
6. Refactor the static emptyDeck() method.
7. Refactor the numberOfCards() method.
8. Refactor the getCards() method.
9. Refactor the shuffled() method. Check out the Collections Utility Class section further down this document for something that could help you shuffle, instead of adjusting the algorithm. It is alway preferable to use logic that is build in, if it suits your needs.
10. Refactor topCard() and popDeck().
11. Refactor pickCard().
12. Refactor splitDeck().
13. Refactor the equals() method.