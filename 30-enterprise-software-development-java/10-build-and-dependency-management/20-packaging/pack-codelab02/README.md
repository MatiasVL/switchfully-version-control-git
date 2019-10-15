# Packaging

During one of your first days (and in the previous codelab), you had to compile your own code instead of letting the IDE do it for you.
Java offers a way to package together those .class files into a single, compressed archive (instead of a plain folder).
- Most often, these archives are JAR's (Java Archives) or WAR's (Web specific Java Archives) 

Lots of libraries and frameworks are also packaged as (multiple) JAR's, 
which we can then include on our own project (as external dependencies).

## Create your own JAR

1. Create a new Java project (outside of the Switchfully project)
    - In Intellij: `File > New > Java Project`
2. Create the following folder structure (`application` and `person` are java packages):
    ```
    simplejarproject
        | output
        | src
            | main
                | java
                    | application
                    | person 
    ```
3. Create a `Person` class in package `person`, it should have a name (`String`) and a `Gender` (Enum, also in package `person`)
4. Create a `MyApplication` class (in the `application` package) which has a main method.
    - It should create a `Person` object
    - It should print a welcome message and the data of the person (override its toString() method)
    - Don't run it yet, otherwise your IDE might already compile your files (which we don't want...)
5. Compile the Java files.
    - We want the .class files to be stored in the `output` folder
    - We want all of our .java files compiled
    - Use the `javac` command (open your terminal / cmd from inside the root folder `simplejarproject`):
        ```
        javac -d "output" src/main/java/application/*.java src/main/java/person/*.java
        ```
    - Find out what the `-d` option does: 
        - https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javac.html (if you use the Java 8 JDK)
        - https://docs.oracle.com/en/java/javase/12/tools/javac.html (if you use the Java 12 JDK)
6. Run the application using the command line
    - From inside the `output` folder, run command: 
        ```
        java application/MyApplication
        ```
    - You should see the output of your application
7. Now, let's package the entire application as a JAR (so we can easily share and run it as a whole)!
8. Still inside your `output` folder, run the following command
    ```
    jar cfe my-packaged-project.jar application.MyApplication application/*.class person/*.class
    ```
    - Based on how IntelliJ handles your sources, it might be that you have to specify `main/java/application/*.class` instead of `application/*class`. (same goes for person).
    - Find out about the `jar` command and what the `-c`, `-f` and `-e` option do: 
        - https://docs.oracle.com/javase/8/docs/technotes/tools/windows/jar.html
        - https://docs.oracle.com/en/java/javase/12/tools/jar.html
    - **Not providing** the `-e` option - in this scenario - will make this JAR non-executable.
    - You can imagine packaging a large project manually can be a pretty cumbersome task to do...
9. At the root level of your `output` folder, the `my-packaged-project.jar` jar file should be generated.
10. Run the JAR file using the `java` command with the `-jar` option
    ```
    java -jar my-packaged-project.jar
    ```
11. Un-package the my-packaged-project.jar file, inspect the Manifest file.
    - Since a .jar file is actually just a zip file you can use any unzipping tool.

