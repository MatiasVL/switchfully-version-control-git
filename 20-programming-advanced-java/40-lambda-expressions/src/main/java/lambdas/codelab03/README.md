# Automated Contact

We've created a fully working automated system for contacting people by phone, mail or e-mail.
- Drivers (person over the age of 16) will be phoned
- Draftees (males, between 18 and 25) will be e-mailed
- Pilots (person between ages 23 and 65) will be mailed (by post)

Inspect the code, inspects the tests and run the tests!
Make sure you understand the code.

## Refactoring, first step!

We are going to refactor `AutomatedContactService`.

- Refactor the `callDrivers`, `emailDraftees` and `mailPilots` method so that they use a functional interface (implemented with a lambda) 
as an argument to validate the criteria whether or not to call, email or mail a person.
  - Criteria:
    - Person must be over the age of 16 (to be called)
    - Person must be male and must be between ages 18 and 25 (to be emailed)
    - Person must be between ages 23 and 65 (to be mailed)
  - Since the criteria to call, email and mail will be provided by the caller of these methods, 
    think about if we should change the name of these methods. Is `callDrivers` still a valid name if we can provide a criteria that no longer matches a driver?
    - You'll also have to change the tests (do this first) and the `Main` class.
  - You don't have to touch the `automatedCall`, `automatedMail` and `automatedEmail` methods and should still use them like you did before.
- From inside the `Main` class, add a call in which you **email** all **pilots**. This should now be fairly easy.

## Refactoring, second step!

First, make sure all your tests are green from your previous refactoring.
Then, continue with the following new requirement

Refactor `automatedContactService` so that it only contains and offers just one method: a method that contacts a given group of people in a given(1) way when a certain condition(2) is met.
- (1) Using a functional interface as an argument (initialized with a lambda so you can remove `automatedCall`, `automatedMail` and `automatedEmail`)
- (2) Using a functional interface as an argument (should already be implemented)
    
You shouldn't have any duplicated lambda expressions in your `Main` class (you can store lambda's in variables and re-use them)

**Important remark:** After completing the final refactoring, our `AutomatedContactService` offers one way to contact 
a group of people in a given way under a certain condition.
Obviously, this is way more flexible than what we had before. However, do note that we did change the behavior and 
API of the `AutomatedContactService`. First, it was strictly controlled by the `AutomatedContactService` who could be 
contacted in what way. After the final refactoring, this can be completely decided by the client (Application).

As its public API, `AutomatedContactService` offered 3 specific methods: `callDrivers`, `emailDraftees` and `mailPilots`. 
After the refactoring, the public API is reduced to a single method (leaving certain implementation details to its caller, client).