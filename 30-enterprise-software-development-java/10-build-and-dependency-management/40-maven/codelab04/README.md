# Multi-module project

We're going to create a multi-module Maven project.

## Requirements

1. One parent project: `maven-multi-module-project`
2. 2 modules: `api` and `domain`
3. Use a groupId of your own
4. Create a `Person` class in module `domain`
5. Create a `MyAPI` class in module `api` which has a `main` method
    - It should create 2 `Person` object
    - It should store them in a list, using the `Lists.newArrayList` method of Guava
    - In the `main` method, it should loop over the list, printing the name of every Person
6. Do **Dependency Management** (`<dependencyManagement>`) in the parent pom
7. Overwrite the correct `properties` to set the source and target runtime version to Java 8 (or higher), so that both modules are compiled against that version. 
8. Use the `maven-jar-plugin` combined with the `maven-dependency-plugin` to create an executable JAR.
    - The main class being `myApi`
    -  Only for module `api`
    - Alternatively, use the `maven-assembly-plugin` to create an executable fat JAR (a fat JAR contains all the JARs of its dependencies, they're packaged inside of our JAR).
        - http://maven.apache.org/plugins/maven-assembly-plugin/
        - Bind goal `single` to phase `package`
        - Our solution uses this plugin.
9. Do **Plugin Management** in the parent pom
    - It works the same way as dependency management, but for plugins
        - So, it creates an on-demand centralized way of defining plugins. 
        If a module wants to use a plugin, it has to specify its groupId and artifactId (again, similar to dependency management).
    - https://maven.apache.org/pom.html#Plugin_Management
    
Run the build: `mvn clean package`
- Which module gets compiled first? Why?
- Inspect the target folders
- Inspect the generated jars

Execute the correct JAR, does it show the program's output?
- If it does, great!
- If it doesn't, figure out what's wrong an make it work... :)

## Finished?

Think you're finished? Ask for some feedback first, only then checkout the solution.
**Do yourself a favor and do not look at the solution beforehand!**
 
The `maven-multi-module-project` project on our GitHub project contains a solution for this codelab.
- Clone (or Fork, then Clone) the project: https://github.com/switchfully/maven-multi-module-project
- Explore the project
- Run the build: `mvn clean package`
    - Which module gets compiled first? Why?
    - Inspect the target folders, what do you notice?
    - Inspect the generated jars.
- You're free to experiment, make changes, extend,... the code
