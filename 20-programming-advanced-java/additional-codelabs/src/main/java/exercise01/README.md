# TDD Candy shop

1.	As a user I want to have a piece of candy, this should contain name price and weight.
2.	As a user I want to create a bag of candy. This should contain pieces of candy. After creation you can’t edit the bag anymore.
3.	As a user I want to know the price of the bag.
4.	As a user I want to know the weight of the bag.
5.	As a user I want to know the amount of candy inside a bag.
6.	You have the following interface to order candy bags from the supplier interface ```SupplierInterface```:
```
public interface SupplierInterface {
    List<CandyBag> orderCandyBags(int numberOfBags);
}
```
Order some bags of candy from the supplier. But don’t implement the interface, only use it.
7.	As a user I want to order the candy bags I receive from the supplier by price.
8.	As a user I want to store the bags of candy inside my shop.
9.	As a user if the store has less than 10 bags of candy I want to order 30 bags of candy.
10.	As a user I want to be able to buy a the first bag of candy from the store.
11.	As a user I want to buy the bag with the lowest price per piece of candy.
12.	As a user I want to log the content of the bag when someone buys a bag of candy.
13.	As a user I want to send a mail when I order candy bags from a supplier.
14.	As a user I want to know the total price I sold at the end of the day.
15.	As a user you can get a piece of candy out of the bag.
