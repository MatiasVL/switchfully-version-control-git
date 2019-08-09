# Using Java on the commandline

A bit of repetition, but also some new learning material.

## Many Java Versions

Because you can have multiple Java version installed on your system at the same time, it's important to know which one is configured to be the active one in your terminal.

Finding out what version of Java you have configured right now, is easy. Open your terminal application and execute the following commands:

```
$ java -version
java version "1.8.0_144"
Java(TM) SE Runtime Environment (build 1.8.0_144-b01)
Java HotSpot(TM) 64-Bit Server VM (build 25.144-b01, mixed mode)
```

or

```
$ java -version
openjdk version "12.0.1" 2019-04-16
OpenJDK Runtime Environment (build 12.0.1+12)
OpenJDK 64-Bit Server VM (build 12.0.1+12, mixed mode, sharing)
```

To change your Java version on Windows, it should be enough to set the `JAVA_HOME` environment variable 
to the correct Java installation path (the location of your JDK on your file system).

(Older versions of Java require you to set up your PATH environment variable with the location to the correct Java binaries.)

> **TASK 1:** Verify what versions of the JVM you have, and if the proper one (at least 1.8) is setup correctly in your terminal.

## The ProgramArguments program

We need a small program that takes an array of Strings and prints them on the screen, each one on a separate line, each line prefixed with the index of the String in the array.
  
The output should look similar to this:

```
0:first
1:second
2:third
```

> **TASK 2:** Implement the printArray method in the ProgramArguments class. 
> Don't forget to run the tests (you can use your IDE) that came with the project.

## Compiling a Java program

To get from the text in a source file (`ProgramArguments.java`) to something the machine, or in the case of Java the Java Virtual Machine, 
can understand and execute (`ProgramArguments.class`), we need another program, the compiler. 
 
In Java this program is named ```javac``` (short for Java Compiler) and comes with your installed JDK.

> **TASK 3:** Open your terminal (CMD) and navigate to the project directory (folder `java` inside of `(...)/comp-codelab01/src/main`) that contains the source file. 
Use the ```javac``` tool to compile the ProgramArguments.java source file.
> 1. What is the result of the compilation? 
> 2. Do you know where your IDE stores the result of the compilation when it does it automatically for you?


## Running a Java program

After compilation, we end up with an **artifact** that we can give to the JVM to execute. For this, we use the ```java``` program. 
You just give it the name of the class that you want the JVM to run as the only argument.

```
$ java ProgramArguments
```

> **TASK 4:** Try running ```java``` now. What happens when you do this? What is the difference with running the tests?

### Adding a Main method

If you're getting "```Error: Could not find or load main class ProgramArguments```", you are doing something wrong.
Verify that you are running ```java``` in the directory where the compiled .class file is located (should be `(...)/comp-codelab01/src/main/java`). 

If you are seeing the following error message, then you're on the right track (we will fix it soon):

> ```
> Error: Main method not found in class ProgramArguments, please define the main method as:
>   public static void main(String[] args)
> or a JavaFX application class must extend javafx.application.Application
> ```

Remember how a Java program requires as `main` method in order to be executed by the JVM? 
The ```main``` method that the error message refers to is the entry point for your application. 
When we ask the JVM to execute class `ProgramArguments`, that class needs a `main` method.

> **TASK 5:**  Add a main method to your program that prints the arguments that were passed when it was started 
from the command line. Finally, run your program again and pass a few arguments to check that it is working.
- When we execute class `ProgramArguments` with arguments (e.g. `java ProgramArguments Here Be Dragons`) the `main` 
method's parameter `String[] args` will contain 3 elements ("Here", "Be", "Dragons").   

```
$ java ProgramArguments Here Be Dragons
0:Here
1:Be
2:Dragons
```

#### Beautification

> **TASK 6:** Modify your program to prefix the output with "Program arguments:" , and to print "None" when no 
arguments have been passed to the application:

```
$ java ProgramArguments
Program arguments:
None
```
