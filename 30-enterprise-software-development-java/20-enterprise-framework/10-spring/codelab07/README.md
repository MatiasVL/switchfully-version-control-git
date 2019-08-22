# ⛔ `System.out.println();` is forbidden! ⛔ (part 2)

## Debugging your Spring application
To debug 🐞 your application, never use `System.out.println();`, always use a debugger!

IntelliJ makes it easy to debug your application from within the IDE with a single click (Or `Shift+F9`).

But it is also possible to connect your debugger to any Java process.
(Both local and remote Java processes).

> ⚡️ACTION: (Codelab activity)
> 1. Using maven: generate an executable jar file from Codelab05 or Codelab06.
> 2. Start your  program on the commandline with the arguments below.
> 3. In IntelliJ create a Remote Run configuration & debug your application.
````
$ java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \
       -jar target/myapplication-0.0.1-SNAPSHOT.jar
````
Reference: https://www.jetbrains.com/help/idea/creating-and-editing-run-debug-configurations.html

## Logging your Spring application
Remember Codelab08 from 20-programming-advanced-java > 10-exceptions > 20-exceptions-combined?
In this codelab Java Logging was introduced, in a way that did not require a dependency. But now you are familiar with Maven and Spring, so let's do it the Spring way!

Repeat after me: If your Java application really _MUST_ print some information to the commandline, never use `System.out.println();`, always use a logging framework.

> ⚡️ACTION: (Codelab activity)
> Add Spring logging to your solution of Codelab05.

````java
@RestController
public class ExampleController {
    Logger logger = LoggerFactory.getLogger(ExampleController.class);
 
    @RequestMapping("/")
    public String helloExample() {
        logger.trace("I'll update you on every heartbeat 💓");
        logger.debug("I'm taking a (sub)step 🚶");
        logger.info("Business as usual, I processed an action correctly");
        logger.warn("Warning ⚠ I do not trust this situation?!");
        logger.error("Help 🆘 Something is broken!");
        return "<h1>`System.out.println();` is forbidden!</h1><p>Logging for the win!</p>";
    }
}
````

References:
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-logging.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html
- https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Logging_Cheat_Sheet.md


## (Optional) Profile your Spring Boot application
> ⚡️(Optional) ACTION: (Codelab activity) Connect with VisualVM to your Spring & Spring Boot application.

NOTE: VisualVM is included in JDK8. Starting with JDK9, you'll have to download it separately.

ALTERNATIVE: Use the IntelliJ JVM Profiler to inspect your application.