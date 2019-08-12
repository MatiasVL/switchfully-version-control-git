# ⛔ `System.out.println();` is forbidden! ⛔ (part 1)
## Logging
To oversee what your Java program is doing and to know keep an eye if it operates correctly, it is best practice to keep records of the events that occur in your application. This is called logging.
Usually, these events are recorded in log files, but it is also possible to store your log in a database or send them to an other server over the network.

You do not only log information about problems (so when exceptions occur), usually limited information about the happy path is also kept in the log.

SO: If your Java application really _MUST_ print some information to the commandline, never use `System.out.println();`, always use a logging framework.

> ⚡️ACTION: (Codelab activity)
> Try the following, and apply it to one of the previous codelabs.

````java
import java.util.logging.*;

public class LoggingExample {
    private static Logger log = Logger.getLogger("codelab08.LoggingExample");
 
    public String helloExample() {
        log.severe("This is a severe log message. It should be used to log severe or unexpected failures.");
        log.warning("This is a warning log message. It should be used to log non-severe failures or exceptional conditions that are expected.");
        log.info("This is an info log message. It should be used to log informative messages that are appropriate for production or customer use.");
        return "<h1>`System.out.println();` is forbidden!</h1><p>Logging for the win!</p>";
    }
}
````

⚠️Note: This is not the most common way to do logging in Java. We'll come back to this in a few weeks to tackle this again.

⚠️Note: OK ... `System.out` is not forbidden. But please only use it in console applications to display results, or to ask input from the user. DO NOT use it for debugging, etc. 

References:
- https://docs.oracle.com/javase/8/docs/technotes/guides/logging/overview.html
- https://docs.oracle.com/javase/8/docs/api/java/util/logging/package-summary.html
- https://docs.oracle.com/en/java/javase/11/docs/api/java.logging/java/util/logging/package-summary.html
- https://docs.oracle.com/en/java/javase/11/core/java-logging-overview.html#GUID-B83B652C-17EA-48D9-93D2-563AE1FF8EDA
- https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Logging_Cheat_Sheet.md
