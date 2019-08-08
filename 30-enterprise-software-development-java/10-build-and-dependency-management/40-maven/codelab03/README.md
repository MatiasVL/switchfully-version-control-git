# Multi-module project

We're going to create the multi-module project that was featured in the slides

## Requirements

1. One parent project: `mymavenmultimoduleproject`
2. 2 modules: `api` and `domain`
3. Use a groupId of your own
4. Create a Person class in `domain`
5. Create a MyAPI class in `api` which has a main method
    - It should create 2 Person object
    - It should store them in a list, using the Lists.newArrayList method of Guava
    - In the main method, it should loop over the list, printing the name of every Person
6. Do dependency management in the parent pom
7. Use the maven-compiler-plugin to set the source and target runtime version to Java 8
    - For both modules
8. Use the maven-assembly-plugin to generate an executable JAR that contains the dependencies
    - The main class being MyApi
    - Only for module `api`
    - Bind goal `single` to phase `package`
9. Do plugin management in the parent pom
    - It works the same way as dependency management, but for plugins
    
Run the build: mvn clean install
- Which module gets compiled first? Why?
- Inspect the target folders
- Inspect the generated jars

Execute the correct JAR, does it show the program's output?

## Finished?

Think you're finished? Ask for some feedback first, only then checkout the solution.
**Do yourself a favor and do not look at the solution beforehand!**
 
The `maven-multi-module-project` project contains a solution for this codelab.

- Explore the project
- Run the build: mvn clean install
    - Which module gets compiled first? Why?
    - Inspect the target folders, what do you notice?
    - Inspect the generated jars.
- You're free to experiment, make changes, extend,... the code
