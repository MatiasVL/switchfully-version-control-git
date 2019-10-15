# External dependencies, manually linked

Guava is a project that contains several very useful libraries on which Google itself relies for their Java projects. 
The entire Guava project is packaged as a single JAR, which we can download and use in our own project.

Let's use it as an example for our first external dependency.

## Link your first external dependency

1. Create a new Java project
    - In Intellij: ```File > New > Java Project```
2. Create the following folder structure:
    ```
    simpleprojectwithdependency
        | output
        | lib
        | META-INF
        | src
            | main
                | java
                    | application
    ```
3. Download the Guava project jar 
    - Go to the following URL
        - https://mvnrepository.com/artifact/com.google.guava/guava
    - Select a version and download the bundle
        - The bundle should consist of a ```.jar``` file
    - Place it in the ```lib``` folder
        - It's a good practice to place your external libraries in a ```lib``` folder
        - The exernal library doesn't have to be in a ```lib``` folder, it can be anywhere in your file system! 
4. Link the Guava jar file to your project's IDE module
    - In Intellij: right click on simpleprojectwithdependency > open module settings > libraries > add Guava
        - This will allows us to already use Guava, do note that this is not a java-specific task, but an IDE task.
5. Create a ```MyApplication``` class (in the ```application``` package)
    - Add the following code:
    ```
        public static void main(String[] args) {
            List<String> helloWorld = Lists.newArrayList("Hello", " World");
            System.out.println(helloWorld.get(0) + helloWorld.get(1));
        }
    ```
    - `Lists` is a Guava class, you should be able to import it to resolve the compilation error!
        - So, we're actually importing and using code from the Guava jar. 
6. Compile the Java files.
    - We want the .class files to be stored in the ```output``` folder
    - We want all of our .java files compiled
    - Use the ```javac``` command (open your terminal / cmd from inside the root folder `simpleprojectwithdependency`):
        ```
        javac -d "output" src/main/java/application/*.java
        ```
7. Something went wrong, right?
    - Something like this, to be precise: ```error: package com.google.common.collect does not exist```
8. When compiling, we have to include (put on the classpath) all other used class files, source files,... (including external dependencies).
Since we're using classes from Guava in ```MyApplication```, we have to include the guava jar. We do this by using the 
```-cp``` option (classpath) and providing its path.
    - Execute the following command:
        ```
        javac -d "output" -cp "lib/guava-version.jar" src/main/java/application/*.java
        ```
        - We set the classpath with the Guava jar. Your code should compile
9. Run the application using the command line
    - From inside the ```output``` folder, run command: 
        ```
        java  -cp .;"../lib/guava-version.jar" application/MyApplication
        ```
    - Yet again, we do have to set the classpath. This time we have to make sure that it contains 
    the current directory (`.`) AND (`;`) the Guava jar (`"../lib/guava-version.jar"`)
    - You should see the output of your application        
10. Now, let's package the entire application as a JAR
    - However, we need to "tell" our JAR where to find its external dependencies...
11. Create a ```MANIFEST.MF``` file in the ```META-INF``` folder
    - It should contain the following content (+ an extra empty line)
        ```
        Class-Path: ../lib/guava-version.jar     
        ```
    - It's considered good practice to put your ```MANIFEST.MF``` file in a ```META-INF``` folder
        - Normally you would place the ```META-INF``` in ```src/main/resources``` but for simplicity we keep it in the root folder
        - Most of the time the MANIFEST.MF file will be auto generated when using the `jar` tool (we can add entries to it, 
        e.g. using option `-e` to add a Main-Class).
12. Still inside your ```output``` folder, run the following command
    ```
    jar cfme  my-dependency-project.jar "../META-INF/Manifest.MF" application.MyApplication application/*.class
    ```
13. At the root level of your ```output``` folder, the ```my-dependency-project.jar``` jar file should be generated.
14. Run the JAR file using the ```java``` command with the ```-jar``` option
    ```
    java -jar my-dependency-project.jar
    ```
15. Unpackage the my-dependency-project.jar file, inspect the Manifest file. 
See that the Guava jar is not packaged inside the my-dependency-project.jar, although it is referenced by code part of my-dependency-project.jar.
Therefore it is of critical importance the guava jar is available (placed on) the classpath. 

Hopefully it's becoming clear that compiling, packaging and managing (external) dependencies becomes 
a huge task on big projects when doing it manually...

It's for that reason we will introduce a build (compilation, packaging, deploying, test-running,...) 
and dependency management tool such as Maven...
