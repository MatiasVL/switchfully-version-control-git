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

## Finished?

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
