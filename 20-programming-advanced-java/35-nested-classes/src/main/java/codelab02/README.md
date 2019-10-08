# Bob the builder

1. Read about the builder design pattern (should you not yet know it)
    - https://refactoring.guru/design-patterns/builder
2. Create a builder for a `Person` with methods for providing a name, firstname, birthday and id.
3. Make sure your builder class is a nested class of `Person`

In the end, I should be able to create a `Person` object like this (pseudo-code):
```
var builder = create-new-instance-of-builder
Person bobby = builder
    .withName("The Builder")
    .withFirstName("Bob")
    .withBirthday(20-01-1980)
    .withId(999)
    .build();
```