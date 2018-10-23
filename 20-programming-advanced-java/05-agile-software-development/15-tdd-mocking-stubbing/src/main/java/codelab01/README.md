# UserService

We've provided a service class called the `UserService`. 
It's fully functioning, but not tested.

## Unit tests
For practicing mocking and stubbing, create a test class `UserServiceTest` in which you
**unit test** the 3 public methods of `UserService`.
- As this is a unit test of the `UserService` class, mock or stub any behavior of its dependencies.
- Since we've implemented the `UserService` using (constructor) dependency injection, you can quickly 
see all the dependencies the `UserService` has. Simply look at the different arguments its constructor has.

## Integration tests
For practicing writing an integration test (to test the integration between more than one unit), 
create a test class `UserServiceIntegrationTest` in which you test the full integration of `UserService` and
its dependencies. Again, write test methods for all 3 public methods of `UserService`.
- Don't perform any mocking or stubbing, we want to test the full integration of all units / components.