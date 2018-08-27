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
    - Place it in your project root folder (simpledependencyproject)
4. Link the Guava jar file to your project's IDE module
    - In Intellij: right click on simpleprojectwithdependency > open module settings > libraries > add Guava
        - This will allows us to already use Guava, do note that this is not a java-specific task, but an IDE task.
5. Create a ```MyApplication``` class (in the ```application``` package)
    - Add the following code:
    ```
        public static void main(String[] args) {
            ArrayList<String> helloWorld = Lists.newArrayList("Hello", " World");
            System.out.println(helloWorld.get(0) + helloWorld.get(1));
        }
    ```
    - Lists is a Guava class, you should be able to import it to resolve the compilation error!
        - So, we're actually importing and using code from the Guava jar. 
5. Compile the Java files.
    - We want the .class files to be stored in the ```output``` folder
    - We want all of our .java files compiled
    - Use the ```javac``` command (you already worked with it before):
        ```
        javac -d "output" src/main/java/application/*.java
        ```
6. Something went wrong, right?
    - Something like this, to be precise: ```error: package com.google.common.collect does not exist```
7. When compiling, we have to include all other user class files, source files,... (including external dependencies).
Since we're using classes from Guava in ```MyApplication```, we have to include the guava jar. We do this by using the 
```-cp``` option (classpath) and providing its path.
    - Execute the following command:
        ```
        javac -d "output" -cp .;"guava_version.jar" src/main/java/application/*.java
        ```
        - We overwrite the classpath with the current directory AND the Guava jar. Your code should compile
8. Run the application using the command line
    - From inside the ```output``` folder, run command: 
        ```
        java  -cp .;"../guava_version.jar" application/MyApplication
        ```
    - Yet again, we do have to overwrite the classpath so that it contains the current directory AND the Guava jar
    - You should see the output of your application        
8. Now, let's package the entire application as a JAR
    - However, we need to "tell" our JAR where to find its external dependencies...
9. Create a Manifest.txt file in your project root folder (simpledependencyproject)
    - It should contain the following content (+ an extra empty line)
        ```
        Class-Path: ../guava_version.jar
        
        ```
9. Still inside your ```output``` folder, run the following command
    ```
    jar cfme  my-dependency-project.jar "../Manifest.txt" application.MyApplication application/*.class
    ```
9. At the root level of your ```output``` folder, the ```my-dependency-project.jar``` jar file should be generated.
10. Run the JAR file using the ```java``` command with the ```-jar``` option
    ```
    java -jar my-dependency-project.jar
    ```
11. Unpackage the my-dependency-project.jar file, inspect the Manifest file. 
See that the Guava jar is not packaged inside the my-dependency-project.jar, although it is referenced