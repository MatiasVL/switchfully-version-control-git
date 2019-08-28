# Spring Dependency Injection fundamentals

> ⚠️WARNING: These are dummy exercises that do show the full power of Spring.\
> They are very narrowly focused on introducing new principles step by step.
> When you apply your Spring knowledge in a bigger project, you'll likely do so in a slightly different way.

## Variation 1 (com.switchfully.springdi.codelab01.v1)
One of the fundamental actions when using Spring, is to define your beans.
As mentioned before, Spring beans are javabeans that are managed by the Spring container.

When running the `main()`-method of the `DrinkSoup` class, you get the chance to drink some soup.
As we are using IoC, you will not create this bean using `new`, but the bean will be fetched from the Spring context.

* Run `DrinkSoup.main()`. \
What happens? What do you learn from this exception? 
* Apply the appropriate changes to the `Royco` class to resolve this runtime error.


* Q: What variations to the solution are possible?
* Q: How would you have solved this earlier, before using Spring?

## Variation 2 (com.switchfully.springdi.codelab01.v2)
Royco is not your only soup option! There are sooo many soups ;-)

* Run `DrinkMoreSoup.main()`. \
  What happens? What do you learn from this exception?
* Apply the necessary changes to drink healthy soup & to resolve the runtime error.


* Q: What variations to your solution are possible?

## Variation 3 (com.switchfully.springdi.codelab01.v3)
`SomeGreatMovies` uses java & Spring to list a few movies.
It does this by printing ALL the beans in the Spring container or application context.

Run `SomeGreatMovies.main()`.
This exposes also some of the Spring internals:
```
org.springframework.context.annotation.internalConfigurationAnnotationProcessor
org.springframework.context.annotation.internalAutowiredAnnotationProcessor
org.springframework.context.event.internalEventListenerProcessor
org.springframework.context.event.internalEventListenerFactory
```
These beans are created by the Spring `AnnotationConfigApplicationContext` for internal purposes.

* Q: Why are there soup beans in this list?
* Modify the `SomeGreatMovies` class to show only the movies (lordOfTheRings, theLionKing, toyStory, anInconvenientTruth) + Spring internal beans.


* Q: Have a look at the [Spring documentation AnnotationConfigApplicationContext](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html) \
How would you change the code so only beans of type Movie are displayed? \
⚠ Documentation is useful, do not learn these details by heart.

## Variation 4 (com.switchfully.springdi.codelab01.v4)
In this variation we'll use a seperate `ApplicationConfiguration` class to define our beans.

Complete the song (Mercedes Benz - Janis Joplin) by creating beans.
Be careful, as all our beans are of the same type (String)

## Variation 5 (com.switchfully.springdi.codelab01.v5)
| ⚠ Remove comments ⚠ |
|--- |
| Before you start, uncomment `@Component` in `DeliveryVan`, `Driver` classes.|
| These comments have only been introduced to avoid issues with variation 3 of this codelab. |

In the previous variations of this codelab, we have focused on creating beans and making sure the `@Componentscan` is set correctly.
Now it is time for the next step: Wire individual beans together.

Adjust the application configuration so `ParcelDeliveryService` works correctly.

## Variation 6 (com.switchfully.springdi.codelab01.v6)
The PhoneFactory sells mobile phones & subscriptions at cheap prices.
They want to improve their software and have asked you to rewrite the `PhoneFactory` class.

Modify the code to use Spring and dependency injection.
The PhoneFactory company prefers it if you'd create a separate Config class.
