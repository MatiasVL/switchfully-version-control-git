# ATM

    |||||||||||||||
    |             |
    |   - ATM -   |
    |             |
    |  __€150__   |
    |  ___   ___  |
    |  |D|   |W|  |
    |             |
    |||||||||||||||
    ||Dolla||Bill||
    |||||||||||||||

Inspect the code, notice how we're creating a ATM window on which we have two buttons and an input field.
It represents a simple ATM terminal.

The `AtmMachine` operates by delegating its actions to (an implementation of) the `BankingFacade` interface.
Currently, there is a simple implementation (`SimpleBanking`) that is currently used by the `AtmMachine`.
Inspect the `AtmApplication` code and see how an instance of `SimpleBanking` is provided to `AtmMachine` upon its creation.

Your job is to create a new implementation of the `BankingFacade`. Call it `SmartBanking`.
The following requirements should be implemented:
1. The balance can never go below 0
2. The max withdrawal limit is 50% of the total balance
    - E.g. When the balance is 500, the max withdrawal limit is 250
3. The max deposit limit is 14500
4. When performing a deposit, the provided amount can not be negative
    - Otherwise I could simply use deposit to increase my balance (and circumvent any restrictions that exist on withdrawal, but not on deposit)
5. When performing a withdrawal, the provided amount can not be negative
    - Otherwise I could simply use withdrawal to decrease my balance (and circumvent any restrictions that exist on deposit, but not on withdrawal)
6. The entered amount is always of type String, so you'll have to transform it to a double.
    - This can go wrong, make sure you take that into account.
    - E.g. the user enters "forty-five" instead of "45"
    
When an illegal argument is provided, make sure to throw an exception with a meaningful, specific message. The AtmMachine will catch them and use
the message to provide feedback to the end-user.