# Build tool: Compiling, packaging and executing

Let's find out how Maven allows us to compile, package and even execute our code.
Reuse your project from the previous codelab.

## Compiling

1. Inside the command line / terminal, at the root of your project, execute the following command
    ```
    mvn clean compile
    ```
2. A `target` folder should be generated, containing all of our project's compiled files.
    - Maven is able to (recursively) find all .java files of your project. We don't need to manually specify all the packages.
    - It's also able to reference the external dependencies (when compiling)
    - It replaces the ``javac`` command and heavily improves the ease-of-use.
    
## Executing

To execute our compiled code, which is not yet packaged, we can use a maven plugin.
To be more precise, we'll use the Exec plugin of MojoHaus (http://www.mojohaus.org/exec-maven-plugin/usage.html)

1. Include the plugin by adding the following code to your `pom.xml`:
    ``` 
    <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>1.6.0</version>
        <executions>
            <execution>
                <goals>
                    <goal>java</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <mainClass>application.MyApplication</mainClass>
        </configuration>
    </plugin>
    ```
    - As with dependencies: 
        - The plugin is located on Maven's central repository
        - We need to correctly specify its group id, artifact id
        - Version is optional, Maven (3.x) will find the latest release
    - The goal `java` helps us to run a Java program
    - The mainClass configuration tells the plugin which main class to use, to run the application
    - a `<plugin>...</plugin>` block always resides in the `<plugins>...</plugins>` block, 
    which on its turn resides in the `<build>...</build>` block.
2. Inside the command line / terminal, at the root of your project, execute the following command
   ```
   mvn exec:java
   ```
   - Besides some output of Maven itself, you should see the output "Hello World" of your executed application.
   - We didn't have to specify our external dependencies as we were required to do when using the `java` command
   
## Packaging

Last but not least, let's look at how Maven facilitates packaging our project.

Since Maven uses Convention over Configuration.
Simply put, this means that whenever we follow the defaults, we don't need any (or just a little configuration).
Whenever we do requires things to be different than the default, we have to tell Maven (by using some configuration).

As with `mvn clean compile`, Maven's command `mvn clean package` expects (by default) 
that our source code is located inside `src/main/java`.

1. Package your code using Maven, execute the following command:
    ```
    mvn clean package
    ```
2. Inspect your `target` folder, see how it now contains a jar with as name your artifact id and version.
3. Try to run your jar (from inside the target folder):
    ```
    java -jar simple-maven-project-1.0.jar
    ```
4. It shouldn't work: `no main manifest attribute, in simple-maven-project-1.0.jar`
5. Let's fix this, by automatically adding the main class to the manifest by using the maven jar plugin
    - Looks like we need some extra configuration after all.
6. Add the following code to your `pom.xml`:
    ```
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.0.2</version>
        <configuration>
            <archive>
                <manifest>
                    <mainClass>application.MyApplication</mainClass>
                </manifest>
            </archive>
        </configuration>
    </plugin>
    ```
7. Again, execute `mvn clean package`
8. It shouldn't work either, the Guava dependency is missing. Inspect the Manifest.mf file.
9. We have multiple approaches: 
    1. Generate a folder that contains all our dependency jars and then add that location to the class path property of our manifest file.
    2. Aggregate all dependencies and package them inside our project's jar.
    3. ...
10. Let's go for the second (aggregate and package inside) approach. Our maven jar plugin is not powerful enough. 
Let's switch to the maven assembly plugin!
11. Remove the maven jar plugin from your `pom.xml`
12. Add the following code to your `pom.xml`:
    ```
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-assembly-plugin</artifactId>
        <version>3.1.0</version>
        <executions>
            <execution>
                <phase>package</phase>
                <goals>
                    <goal>single</goal>
                </goals>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>
                                application.MyApplication
                            </mainClass>
                        </manifest>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
            </execution>
        </executions>
    </plugin>
    ```
13. See how there are now 2 jars created, we're interested in the `simple-maven-project-1.0-jar-with-dependencies.jar`
14. Run this jar, from inside the `target` folder using:
    ```
    java -jar simple-maven-project-1.0-jar-with-dependencies.jar
    ```
15. This should work and output your "Hello World" message.
16. Inspect this jar, see what is included.
   