

## Operation Cedar (starting point: `3-operation-cedar`)
In the previous story we implemented 'Role based'-security. There is another way to approach this, however: feature based security.

But first, let's switch to a userstore that's a bit closer to reality. Out goes the inMemoryAuthentication and in comes your very own authenticationProvider!

You will have to get rid of the inMemoryAuthentication in your Spring SecurityConfig class and replace it by a custom AuthenticationProvider.
This is a class that extends AuthenticationProvider. You will have to implement two methods: 'authenticate' and 'supports'.

### Implementing the authenticate() method
In the package 'external.authentication' you will find the class 'FakeAuthenticationService'. 
You will have to provide this class with a username and a password. 
If the combination is correct, this service will return an Object that contains the username, password and roles of the user.
If the combination is incorrect, it will return null.

The authenticate should return an 'Authentication' object if the username/password combo exists. 
Otherwise it should throw an exception that extends the AuthenticationException class.
Pick one you think fits the bill.
**HINT**: This method is a great candidate for some unit-tests.

### Implementing the supports() method
This method determines if the custom AuthenticationProvider will handle the Authentication request. In our case, the provider handles Username/Password Authenticationtokens.
The standard Java method 'isAssignableFrom()' might help you.

Note that no extra end-to-end tests have been provided for this story. 
That's because the existing behaviours aren't altered in any way. So after you're done, all the other tests should still run.

### Oh right, one more thing:

When using a custom AuthenticationProvider, Spring pretty much requires you to be using feature based security. 
To not make the story even bigger than it already is, we're gonna cheat a bit on that part (don't worry, we'll implement it properly in the next story).
To fix everything up, change your 'hasRole'- and 'hasAnyRole'-code in the ArmyResource and/or SecurityConfig to 'hasAuthority' and 'hasAnyAuthority'.
If everything is implemented correctly, both the baobabTest and the AvocadoTest should run.

## Operation Dogwood (starting point: `4-operation-dogwood`)

Back to feature-based security. To get up to speed about the benefits feature-based security has, read [the following post on stackexchange](https://softwareengineering.stackexchange.com/questions/299729/role-vs-permission-based-access-control).

You've already completed one step along the way: using the 'hasAuthority' method/annotation.
Next, we'll have to create the different features and couple them to the role(s) that are allowed to access them.

Once you've got that coupling, you'll have to fill up the  your custom Authentication class's roles (GrandedAuthority's) correctly.
The FakeAuthenticationService will provide you with the role(s) of the logged in users. You'll have to map those roles to the allowed features manually.

Once again, there are no new end to end tests. The old tests should keep working after you're done, ofcourse.

Extra info:
- [Another article on role based vs feature based (called 'activity based' here)](https://lostechies.com/derickbailey/2011/05/24/dont-do-role-based-authorization-checks-do-activity-based-checks/)

## Operation Elm (starting point: `5-operation-elm`)
There is one more way we can perform an extra check before allowing or denying access: using the 'access' method in the 'configure' method in our Spring security config file.
You've already used the 'antMatchers' method in Operation Baobab. If you try chaining the 'antMatchers()' method, you'll see you can call a method called 'access()' on it.

This method takes a Spring expression String using the following structure:
.access("@SpringBeanClass.methodOnThatClass(#nameOfSomeRestMethodParameter)");

An example:

.antMatchers(GET, "/my/rest/api/{somePathParam}").access("@antiHackerService.stopHackers(#somePathParam)");

The method that is called should return a boolean: true if the call should be allowed, false if it should be denied.

Your task is to stop people from getting promoted if they've got a criminal record. 
To check if someone has a criminal record, you can use the CriminalRecordService in the external package. 
Its method 'hasCriminalRecord' takes a username (a.k.a. the path param from the rest call) and returns a 'CriminalRecord' object.
If the 'offenses' on this object are empty, the person is 'clean'.

A couple of new accounts have been added to the FakeAuthenticationService, some of them with criminal records, others without. 

## Extraction Point (for a look at the final code: `6-operation-extraction`)

Congratulations, [a winner is you](http://i0.kym-cdn.com/photos/images/facebook/000/048/783/a_winner_is_you20110724-22047-1nd3wif.jpg)!
You've completed all stories and made the lives of your fellow countrymen a little safer. 
See any of your fellow students struggling? 
Try giving them a helping hand (don't just mail them your code, nobody learns anything from blindly copy-pasting text from one app to another).


