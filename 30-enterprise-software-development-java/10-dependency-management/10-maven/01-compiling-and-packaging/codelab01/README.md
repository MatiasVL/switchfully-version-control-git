# External dependencies

During one of your first days, you had to compile your own code. Since then, we've let our IDE handle that for us. 
Java offers a way to package together those .class files into a single, compressed archive. 

Lots of libraries and frameworks are packaged as JAR's, 
which we can then include on our own project (as external dependencies). 
As a first step in learning about external dependencies and dependency management, 
let's see how we can create our own JAR's.

## Create your own JAR

1. Create a new Java project
    - In Intellij: ```File > New > Java Project```
2. Create the following folder structure:
    ```
    simplejarproject
        | output
        | src
            | main
                | java
                    | application
                    | person 
    ```
3. Create a ```Person``` class in package ```person```, it should have a name and a ```Gender``` (Enum, also in package ```person```)
4. Create a ```MyApplication``` class (in the ```application``` package) which has a main method.
    - It should create a person
    - It should print a welcome message and the data of the person (override its toString() method)
    - Don't run it yet, otherwise your IDE might already compile your files (which we don't want...)
5. Compile the Java files.
    - We want the .class files to be stored in the ```output``` folder
    - We want all of our .java files compiled
    - Use the ```javac``` command (you already worked with it before):
        ```
        javac -d "output" src/main/java/application/*.java src/main/java/person/*.java
        ```
    - Find out what the ```-d``` option does: https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javac.html
6. Run the application using the command line
    - From inside the ```output``` folder, run command: 
        ```
        java application/MyApplication
        ```
    - You should see the output of your application
7. Now, let's package the entire application as a JAR (so we can easily share and run it as a whole)!
8. Still inside your ```output``` folder, run the following command
    ```
    jar cfe my-packaged-project.jar application.MyApplication application/*.class person/*.class
    ```
    - Find out about the ```jar``` command and what the ```-c```, ```-f``` and ```-e``` option do: https://docs.oracle.com/javase/8/docs/technotes/tools/windows/jar.html
    - You can image packaging a large project manually can be a pretty cumbersome task to do...
9. At the root level of your ```output``` folder, the ```my-packaged-project.jar``` jar file should be generated.
10. Run the JAR file using the ```java``` command with the ```-jar``` option
    ```
    java -jar my-packaged-project.jar
    ```
11. Unpackage the my-packaged-project.jar file, inspect the Manifest file.

