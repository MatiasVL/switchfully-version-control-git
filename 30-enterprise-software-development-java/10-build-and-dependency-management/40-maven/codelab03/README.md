# Dicer Application

1. Create a new Maven project (instead of a normal Java project)
    - In Intellij: ```File > New > Project > Maven```
    - Accept the default options (no archetype).
    - As the `groupId`, use `com.switchfully.dicer` or, if you like, something else.
    - As the `artifactId` use `dicer-app` or, if you like, something else.
2. A project structure following the maven conventions should be created, additionally, a `pom.xml` will be created.
3. It should look something like this:
    ```
    dicer-app
        | src
            | main
                | java
        | pom.xml
    ```
4. Inside `src/main/java`, create package structure `com.switchfully.dicer` (it's common practice to use the same base-package structure as your `groupId`).

## The actual application

Our dicer-app will have a `main` method inside of the `DicerApplication` class. It rolls a normal six-sided dice 3 times and print the results to the console.

`DicerApplication.java` should contain the following code:
```java
package com.switchfully.dicer;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class DicerApplication {

    private static final int START_INCLUSIVE = 1;
    private static final int END_EXCLUSIVE = 7;

    public static void main(String[] args) {
        ArrayList<Integer> diceRolls = Lists.newArrayList(
                RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE),
                RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE),
                RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE));

        diceRolls.forEach(diceRoll -> System.out.println("Rolled " + diceRoll));
    }
}
```
- `RandomUtils` is part of the commons-lang3 library (`import org.apache.commons.lang3.RandomUtils;`)
- `Lists.newArrayList` is part of the Guava library (`import com.google.common.collect.Lists;`)

## Configure Maven

Now, it's up to you to correctly configure Maven by modifying the POM file.

Do what's necessary so that:
1. Executing `mvn clean compile` will compile our code withouth any problem
2. Executing `mvn clean package` will package our code into an executable JAR.
    - Running the JAR should be possible using `java -jar <name-of-artifact>.jar`
    - It should display the program's output (e.g.):
        ```
        Rolled 3
        Rolled 6
        Rolled 6
        ```
## Finished with the above?

If you're finished with the above, we're going to add a test and make sure that every time we package our code, 
the tests are ran beforehand. Only if our tests succeed, will a new archive be created.

1. Get the dependency of the latest version of JUnit 5 (Jupiter API to write tests, Jupiter Engine to run our tests)
    - Jupiter API: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    - Jupiter Engine: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine
    - No RC (release candidate) or  M (milestone) suffixed dependencies.
2. Add the dependencies to the `pom.xml file`
3. Create the `src/test/java` folder structure.
4. Go to `DicerApplication` and in IntelliJ press `ctrl` + `shift` + `t` to create a test for it.
    - Alternatively: create package `com.switchfully.dicer` in `src/test/java`. Then, in `com.switchfully.dicer` create file `DicerApplicationTest`.
5. Then, create the following dummy test method:
    ```
    @Test
    void justADummyTest() {
        Assertions.assertTrue(false); // this test will fail
    }
    ```
6. Maven's Surefire plugin is by default configured to the `test` build phase (the `test` goal of plugin `surefire` is bound to the `test` build base).
    - https://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html
7. However, to make sure the correct version of the Surefire plugin is used, we're going to specify our own version:
    ```
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.2</version>
    </plugin>
    ``` 
    - Add the above configuration to your `pom.xml` file.
8. Now, run `mvn clean test` (or `mvn clean package` as build phase `test` precedes build phase `package`)
    - The build should not succeed (BUILD FAILURE). If you used `package`, no archive (JAR) will be created.
    - Inspect the output, it should look something like this:
    ```
    [ERROR] Failures: 
    [ERROR]   DicerApplicationTest.justADummyTest:10 expected: <true> but was: <false>
    [INFO]
    [ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
    [INFO]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD FAILURE
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  3.681 s
    [INFO] Finished at: xxxx-xx-xx
    [INFO] ------------------------------------------------------------------------
    [ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.22.2:test (default-test) on project dicer-app: There are test failures.
    [ERROR]
    [ERROR] Please refer to <your-local-path>\dicer-app\target\surefire-reports for the individual test results.
    [ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
    [ERROR] -> [Help 1]
    [ERROR]
    [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
    [ERROR] Re-run Maven using the -X switch to enable full debug logging.
    [ERROR]
    [ERROR] For more information about the errors and possible solutions, please read the following articles:
    [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
    ```
9. Fix your test, change the code to:
    ```
    @Test
    void justADummyTest() {
        Assertions.assertTrue(true);
    }
    ```
10. Re-run your build, use `mvn clean package`.
    - The tests will run
    - If they succeed, the archive will be created.

Now, only if all the test succeed will we deliver a new - fully working (without bugs hopefully) artifact.

## Completely Finished?

Think you're finished? Ask for some feedback first, only then checkout the solution.
**Do yourself a favor and do not look at the solution beforehand!**
 
The `maven-single-module-project` project on our GitHub project contains a solution for this codelab.
- Clone (or Fork, then Clone) the project: https://github.com/switchfully/maven-single-module-project
- Explore the project
- Run the build: `mvn clean package`
    - Which module gets compiled first? Why?
    - Inspect the target folders, what do you notice?
    - Inspect the generated jars.
- You're free to experiment, make changes, extend,... the code
