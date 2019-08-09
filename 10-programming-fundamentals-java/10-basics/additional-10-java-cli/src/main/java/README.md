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

To change your Java version, it should be enough to set the JAVA_HOME environment variable to the correct Java installation path.

On a Mac:

```
# get a list of all installed JVMs
/usr/libexec/java_home -V

# get the home for an installed 1.8 JVM
/usr/libexec/java_home -v 1.8

# export JAVA_HOME to select a Java 1.8
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`

# print out the current java -version
java -version
```

On Windows:

```
# list all JVMs installed in the default location:
dir C:\Program Files\Java

# permanently set JAVA_HOME env variable
setx JAVA_HOME C:\Program Files\Java\{some JDK}

# restart your terminal
exit

# print out the current java -version
java -version
```

Older versions of Java require you to set up your PATH environment variable with the location to the correct Java binaries.

> **TASK 1:** Verify what versions of the JVM you have, and if the proper one (at least 1.8) is setup correctly in your terminal.

## The GitHubLinkGenerator program

We need a small program that takes an array of Strings and prints them on the screen, each one on a separate line, each line prefixed with the index of the String in the array.
  
The output should look similar to this:

```
0:first
1:second
2:third
```

> **TASK 2:** Use your preferred IDE to implement the printArray method in the GitHubLinkGenerator class. 
> Don't forget to run the tests that came with the project.

## Compiling a Java program

To get from the text in a source file (GitHubLinkGenerator.java) to something the machine, or in the case of Java the Java Virtual Machine, can understand and execute (GitHubLinkGenerator.class), we need another program. This program is called a compiler and it takes source code and transforms it into machine code. 
 
In Java this program is named ```javac``` (short for Java Compiler).

> **TASK 3:** Open your terminal application and navigate to the project directory that contains the source file. Use the ```javac``` tool to compile the GitHubLinkGenerator source file.
> 1. What is the result of the compilation? 
> 2. How does this differ from what your IDE is doing? 
> 3. Do you know where your IDE stores the result of compilation?


## Running a Java program

After compilation, we end up with an **artifact** that we can give to the JVM to execute. For this, we use the ```java``` program. You just give it the name of the class that you want the JVM to run as the only argument.

```
$ java GitHubLinkGenerator
```

> **TASK 4:** Try running ```java``` now. What happens when you do this? What is the difference with running the tests?

### Adding a Main method

If you're getting "```Error: Could not find or load main class GitHubLinkGenerator```", verify that you are running ```java``` in the directory where compiled .class file is located. If you are seeing the following error message, then you're on the right track:

> ```
> Error: Main method not found in class GitHubLinkGenerator, please define the main method as:
>   public static void main(String[] args)
> or a JavaFX application class must extend javafx.application.Application
> ```

The ```main``` method that the error message refers to is the entry point for your application. We use this method to call the other methods that bootstrap our program. 

> **TASK 5:**  Add a main method to your program that prints the arguments that were passed when it was started from the command line. Finally, run your program again and pass a few arguments to check that it is working.

```
$ java GitHubLinkGenerator Here Be Dragons
0:Here
1:Be
2:Dragons
```

#### Beautification

> **TASK 6:** Modify your program to prefix the output with "Program arguments:" , and to print "None" when no arguments have been passed to the application:

```
$ java GitHubLinkGenerator
Program arguments:
None
```

### Mastering the ClassPath

> [Classpath][] is a parameter in the Java Virtual Machine or the Java compiler that specifies the location(s) of user-defined classes and packages. The parameter may be set either on the command-line (-cp), or through an environment variable (CLASSPATH).

[Classpath]: https://docs.oracle.com/javase/tutorial/essential/environment/paths.html

By now, you have run your program with the ```java GitHubLinkGenerator``` command about half a dozen times. If you have given it any thought, it is possible you were thinking that the command you were giving the JVM is to take the ```GitHubLinkGenerator.class``` file and execute it.
  
> **TASK 7:** Try running your program again, this time using the .class name:
> ```java GitHubLinkGenerator.class```

What's happening here? Clearly, writing "GitHubLinkGenerator" isn't shorthand for ```GitHubLinkGenerator.class```. What you are actually telling the JVM is: find me the Class (not class-file) with name ```GitHubLinkGenerator```, and run its main method. To find that Class, the JVM goes through the classpath, looking for any .class-file containing a Class called GitHubLinkGenerator. It dynamically (at runtime) loads that Class (and all of the Classes it depends on), and invokes its main method. Just now, you were telling it to load a Class ```GitHubLinkGenerator.class``` that doesn't exist.

Yet when you were trying to run the GitHubLinkGenerator class before, you weren't having any problems. That is because the current directory is implicitly part of the classpath.

> **TASK 8A:** Change (cd) to the 01-programming-fundamentals directory a few levels up. Try running the ProgrammingArguments class.

> **TASK 8B:** Stay at this directory. This time, use the classpath parameter of the java command to run your GitHubLinkGenerator program again. You will have to point the classpath to the directory where your GitHubLinkGenerator class is located. Look at java -help to help you get going.


## Java Archive (Jar)

A jar file is a collection of Java class files and resources (images, data, configs, ...) stored inside a zipped archive, together with a Manifest file that specifies things about its contents (like which class is the main class).

### Creating a Jar

We will create a jar that packages your single class file ```GitHubLinkGenerator.class```. To set this jar up to run our program when the jar is loaded, we need to create a manifest file containing the following line:

> Main-Class: GitHubLinkGenerator

In the terminal, while still located in the ```01-programming-fundamentals``` directory, creating the manifest is a one-liner:

```
# Windows:
@echo Main-Class: GitHubLinkGenerator > manifest

# Unix:
echo "Main-Class: GitHubLinkGenerator" > manifest
```

Finally, to [create a jar](jarfiles) we use the ```jar``` command line utility.

[jarfiles]: https://docs.oracle.com/javase/tutorial/deployment/jar/index.html
 
```
jar cvfm programarguments.jar manifest -C 01-basics/Additional-01-java-cli/src/main/java/ GitHubLinkGenerator.class

    c               create a jar archive
    v               verbosely show the files being packaged
    f               write jar to a file
    m               read manifest from a file
    progr...jar     filename of the jar
    manifest        filename of the manifest
    -C dir          root directory of files added to the jar
    Progr..class    the file(s) to add (could be multiple files and dirs) 
```

> **TASK 9:** If you haven't already done so, create the manifest and the jar.

### Using a Jar

Once we have a jar, we can put it on the classpath to be able to use the classes that are located within (as a library of sorts). But in the case of your jar, where we have configured the Main class in its manifest, we can tell the JVM to run the jar as an application:
 
```
$ java -jar programarguments.jar The Force Is With Me
Commandline arguments:
0:The
1:Force
2:Is
3:With
4:Me
```

> **TASK 10:** Run the jar you have just created. In addition, try the alternative of adding the jar to the classpath and running your program  as before, by calling the classname GitHubLinkGenerator. 

## Memory Constraints

The JVM, when started, [reserves a big slab of memory](https://www.ibm.com/developerworks/library/j-codetoheap/) that it will need later to allocate classes and objects. Classes (loaded from a file) go into the native heap. Objects (loaded from a class) go into the Java heap. The Java heap is the only heap of memory that we can control. But why would we want to? Well, the JVM reserves a standard amount of Java heap that might not be enough for the program that you are writing. How big this standard amount is, depends partly on how much memory you have in total. Another possibility is that you want to limit the reserved amount because your program is small and simple.

![](https://www.ibm.com/developerworks/library/j-codetoheap/figure1.gif)

To manage the Java heap, the JVM provides two parameters:
```
-Xms<size>        set initial Java heap size
-Xmx<size>        set maximum Java heap size
```

The ```<size>``` argument is in bytes, and must at least 1048576. Alternative notations like 1024K and 1M are also supported for kilobyte and megabyte respectively.

> **TASK 11:** Try limiting the maximum heapspace of your program to the smallest amount that doesn't crash your program with an OutOfMemory error. Can't get your program to reach its memory limits and crash? Figure out a way to use more memory and break things!
