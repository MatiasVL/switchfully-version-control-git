# TDD Bank account

1.	As a user I want to have a bank account with a name a bank account number and an amount.
2.	As a user I want to withdraw money from an account.
3.	As a user I want to deposit money from an account.
4.	As a user I want to transfer money from an account to another one. 
This transfer should contain a description, a bank account number and an amount.
5.	As a user I don’t want to be able to do a withdrawal or transfer when I don’t have enough money.
6.	As a user I want to see all transfers I made to a specific bank account.
7.	As a user I want to send a mail when I’m transferring an amount over €3000. 
Do not implement the mailing itself, use an interface.
8.	As a user I want to have multiple bank accounts in a bank.
9.	As a user I can ask the central bank for the transfers that have been made to my accounts. 
Use the ```CentralBank``` interface but don’t implement it:
```
public interface CentralBank {
    List<Transfers> getTransfers();
}
```
10.	As a user I want to find all transfers on any account with an amount larger than €10000.
11.	As a user I want to find all transfers from the last month.
12.	As a user I want to add an address to the account
13.	As a user I want to ask to print my current balance
14.	As a user I want to log all transfers I received from the central bank
15.	As a user I want to log all transfers I initiated.
