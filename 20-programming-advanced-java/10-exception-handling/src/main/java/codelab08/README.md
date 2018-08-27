# Strict bank account

- Create your own custom validation Exception
- Create a service which creates new bank accounts
- Creating a bank account is not easy, the following validation rules apply:
    - person should be at least 18 years old
    - person should have a first and last name
    - person should have an address
    - bank account should have a starting amount
    - bank account should never go under 0
- If a validation rule is broken, an validation exception should arise
- Implement all the different validation rules, 
but always first write a test for a validation rule and only then implement it.