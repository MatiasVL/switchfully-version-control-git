# Automated Contact

We've created a fully working automated system for contacting people by phone, mail or e-mail.
- Drivers (person over the age of 16) will be phoned
- Draftees (males, between 18 and 25) will be e-mailed
- Pilots (person between ages 23 and 65) will be mailed

Inspect the code, inspects the tests and run the tests!
Make sure you understand the code.

## Refactoring, first step!

Refactor AutomatedContactService so that it features less duplicated code and is more flexible.
- Refactor the callDrivers, emailDraftees and mailPilots method so that they use a callback method 
that validates the criteria to call, email or mail a person.
    - Since the criteria to call, email and mail will be provided by the caller of these methods, 
    think about if we should change the name of these methods...
    - You'll have to change the tests (do this first) and the Main class.
- Expand the main method (and write a test) so that it calls the method to phone, but uses the criteria of pilots. 
In other words, pilots should be phoned. It should be easy to do, since you're code is more flexible. 
However, you'll notice the code in your Main class contains some duplication and might be a little bit harder to read.

## Refactoring, second step!

First, make sure all your tests are green from your previous refactoring.
We'll now improve our code by using lambda's!

- Instead of the callback methods, use lambda's. Use one of the lambda's (functional interfaces) offered by Java,
it offers one that perfectly fits your needs.
    - You'll also have to refactor your tests!
    - You'll also have to refactor the Main class.

- In the end, expand your Main class so that it also does the following:
    - Mail all draftees
    - Call all pilots (should already be added)
    - Email all drivers
    - Email all pilots
    
You shouldn't't have any duplicated code in your Main class (you can store lambda's in variables and re-use them)
