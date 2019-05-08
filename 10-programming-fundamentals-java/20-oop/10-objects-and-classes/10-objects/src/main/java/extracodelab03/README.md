# BankAccount

**For your information**: This extra, optional codelab already covers the creation of classes 
(which is different than creation object / instances of classes).
Creating classes will be covered in the next module (module: classes)

## Creating the BankAccount class

It should have the following state:
- accountNumber (String)
- name (String)
- balance (int)

It should have one constructor which you pass the following arguments:
- accountNumber
- name

It should have another constructor which you pass the following arguments:
- accountNumber
- name
- balance

For each attribute, create a method that returns that value:
- accountNumber
- name
- balance

Create the following methods, which set / modify the following values
- A method **credit** to add a certain, given amount to the balance (+ return the new balance)
- A method **debit** to subtract a certain, given amount from the balance (+ return the new balance)
    - If the amount to subtract is bigger than the current balance, print a message and don't subtract (simply return the balance as is)
- A method to **transfer** a given amount to a given (other) BankAccount
    - The current BankAccount should be **debited** with the provided amount.
    - The (other) BankAccount should be **credited** with the provided amount.     
    - However, the given amount can not be bigger than the available balance of the current BankAccount
        - If it is bigger, print a message and don't debit the current BankAccount and don't credit the other BankAccount 
    - Always return the (new) balance (of the current BankAccount)

Create a method to get the textual representation of BankAccount
- Tip: there is a Java specific method for this (that we can override)