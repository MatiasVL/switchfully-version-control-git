# Build tool: Compiling, packaging and executing

Let's find out how Maven allows us to compile, package and even execute our code.
Reuse your project from the previous codelab.

## Compiling

1. Inside the command line / terminal, at the root of your project, execute the following command
    ```
    mvn clean compile
    ```
2. Most likely, an **error** was thrown. Let's see why that error is thrown and how to solve it (even if you didn't receive the error).
    - You will have received the following error:
    ```
    [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project sample-maven-project: Compilation failure: Compilation failure:
    [ERROR] Source option 5 is no longer supported. Use 7 or later.
    [ERROR] Target option 5 is no longer supported. Use 7 or later.
    ```
    - The default Java compiler version used by Maven('s compiler plugin) is Java (1.)5. 
    Our code itself is written in Java 8 or up. To make Maven compile our code with a newer version of the Java compiler, 
    we will need to explicitly configure the Maven compiler to use the given version of the Java compiler.
    - Luckily, this is rather easily done. The Maven compiler plugin uses two properties for this, we can simply overwrite these properties to set the version of the Java compiler.
    - Add the following code to the `pom.xml` file (`<properties>`) is a direct child of `<project>` (do this even if you didn't receive the error):
        ```
        <properties>
            <maven.compiler.target>1.8</maven.compiler.target>
            <maven.compiler.source>1.8</maven.compiler.source>
        </properties>
        ```  
3. Rerun `mvn clean compile`, a `target` folder should be generated, containing all of our project's compiled files.
    - Maven is able to (recursively) find all .java files of your project. We don't need to manually specify all the packages.
    - It's also able to reference the external dependencies (when compiling)
    - It replaces the ``javac`` command and heavily improves the ease-of-use.
    
## Executing

To execute our compiled code, without packaging it as a JAR first, we can use a maven plugin.
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
   - We run the `java` goal of the `exec` plugin.
   - Besides some output of Maven itself, you should see the output "Hello World" of your executed application.
   - We didn't have to specify our external dependencies as we were required to do when using the `java` command
   
## Packaging

Last but not least, let's look at how Maven facilitates packaging our project.

Maven uses **Convention over Configuration.**
Simply put, this means that whenever we follow the defaults, we don't need any (or just a little configuration).
Whenever we do something that requires things to be different than the default, we have to tell Maven (by adding some configuration).

As with `mvn clean compile`, Maven's command `mvn clean package` expects (by default) 
that our source code is located inside `src/main/java`.

1. Package your code using Maven, execute the following command:
    ```
    mvn clean package
    ```
    - *Remember, the `package` phase comes after the `compile` phase. So our code will first be compiled.*
2. Inspect your `target` folder, see how it now contains a jar with as name your artifact id and version.
3. Try to run your jar (from inside the target folder):
    ```
    java -jar simple-maven-project-1.0.jar
    ```
4. It shouldn't work, you will receive a: `no main manifest attribute, in simple-maven-project-1.0.jar` error.
    - By default, Maven will package our code as a non-executable JAR. Furthermore, no dependencies will be put on the classpath.

## Package as an executable JAR

1. Let's make our JAR an executable JAR. For this we need the help of the Maven JAR Plugin.
    - https://maven.apache.org/plugins/maven-jar-plugin/
    - By default, the `jar` goal of the Maven JAR plugin (also, `jar`) is hooked up to the `package` phase. 
    However, it requires some additional configuration to make its resulting archive a fully working executable JAR.
2. Add the following code to your `pom.xml`:
    ```
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.1.2</version>
        <configuration>
            <archive>
                <manifest>
                    <mainClass>application.MyApplication</mainClass>
                </manifest>
            </archive>
        </configuration>
    </plugin>
    ```
3. Again, execute `mvn clean package`, then from within the `target` folder, try executing the generated JAR (`java -jar simple-maven-project-1.0.jar`).
4. It's still not working... the Guava dependency is missing. 
Inspect the `MANIFEST.MF` file, see that no dependencies are put on the classpath...

### Add dependencies to the classpath

Our packaged code uses classes (code) from other libraries (other JARs, like Guava).
Our own JAR should know where to find these other JAR files.

1. We have multiple approaches to fix this issue: 
    1. Generate a folder (e.g. `lib`) that contains all our dependency jars and then add that location to the classpath property of our manifest file.
    2. Aggregate all dependencies and package them inside our project's jar.
    3. ...
2. Let's go for the first approach, for this we need an additional plugin, the Maven Dependency Plugin.
    - https://maven.apache.org/plugins/maven-dependency-plugin/
3. Add the following code to your `pom.xml`:
    ```
    <plugin>
    	<groupId>org.apache.maven.plugins</groupId>
    	<artifactId>maven-dependency-plugin</artifactId>
    	<version>3.1.1</version>
    	<executions>
    	  <execution>
    		<id>copy-dependencies</id>
    		<phase>package</phase>
    		<goals>
    		    <goal>copy-dependencies</goal>
    		</goals>
    		<configuration>
    		    <outputDirectory>${project.build.directory}/lib/</outputDirectory>
    		</configuration>
    	    </execution>
    	</executions>
      </plugin>
    ```
4. Then, update the Maven compiler plugin configuration. Add the `classpathPrefix` and `addClasspath` elements:
    ```
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.1.2</version>
        <configuration>
            <archive>
                <manifest>
                    <mainClass>application.MyApplication</mainClass>
                    <classpathPrefix>lib/</classpathPrefix>
                    <addClasspath>true</addClasspath>
                </manifest>
            </archive>
        </configuration>
    </plugin>
    ```
5. All our (external) dependencies will be copied to the `/target/lib` folder, then, in our `MANIFEST.MF`, 
these dependencies will be added to the classpath.
6. Execute `mvn clean package`. 
7. Run your jar (from inside the target folder):
    ```
    java -jar simple-maven-project-1.0.jar
    ```
8. This should work and output your `"Hello World"` message.

Should you want to give your JAR file to someone else, so that they can execute it on their computer, you will have to give them the entire `lib` folder as well.
- Note that it's also possible to include all dependencies in one (fat) JAR (out of scope for this module).

