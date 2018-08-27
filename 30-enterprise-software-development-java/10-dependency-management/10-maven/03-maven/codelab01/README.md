# Build tool: Dependency Management

Let's recreate our simple project, but this time using build tool Maven.
For now, we'll focus on managing our external dependencies.
We'll focus on packaging in the next codelab.

## Installing Maven

Let's first install Maven, so we can use it from the command line.

1. Go to https://maven.apache.org
2. Download Maven
3. Unpack to a convenient location
4. Go to your Environment Variables, add the ```bin``` directory to the ```Path``` System variable.
    E.g.: ```D:\apache-maven-3.5.2\bin```
5. Open up your command line / terminal and execute the ```mvn -v``` commando, you should get a similar-ish result:
    ```
    Apache Maven 3.5.2 (138edd61fd100ec658bfa2d307c43b76940a5d7d; 2017-10-18T09:58:13+02:00)
    Maven home: D:\apache-maven-3.5.2\bin\..
    Java version: 1.8.0_111, vendor: Oracle Corporation
    Java home: D:\Program Files\Java\jdk1.8.0_111\jre
    Default locale: en_US, platform encoding: Cp1252
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
    ```

## Dependency Management with Maven

1. Create a new Java project
    - In Intellij: ```File > New > Java Project```
2. Create the following folder structure:
    ```
    simpleprojectwithmaven
        | src
            | main
                | java
                    | application
    ```
3. At the root level of your project, create the Maven pom file ```pom.xml```
4. Insert the following xml:
    ````
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns = "http://maven.apache.org/POM/4.0.0"
             xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
    
        <!-- The group id, artifact id and version. This information is project-specific -->
        <groupId>com.switchfully.maven-project</groupId>
        <artifactId>simple-maven-project</artifactId>
        <version>1.0</version>
    </project>
    ````
5. Reimport Maven in IntelliJ (right click module > Maven > Reimport). 
Intellij should now know that it should build the project / module using Maven.
6. Let's include Guava as an external dependency. We can now do this using Maven:
    - Go to Guava on Maven's central repository: https://mvnrepository.com/artifact/com.google.guava/guava
    - Select a version
    - From the Maven tab, copy the xml block: `<dependency>...</dependency>`
    - Paste it in your `pom.xml`
        - ```<dependency>...</dependency>``` block(s) always reside inside the `<dependencies>...</dependencies>` block
7. Your `pom.xml` should look something like this:
     ```
     <?xml version="1.0" encoding="UTF-8"?>
     <project xmlns="http://maven.apache.org/POM/4.0.0"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
         <modelVersion>4.0.0</modelVersion>
     
         <!-- The group id, artifact id and version. This information is project-specific -->
         <groupId>com.switchfully.maven-project</groupId>
         <artifactId>simple-maven-project</artifactId>
         <version>1.0</version>
     
         <dependencies>
             <dependency>
                 <groupId>com.google.guava</groupId>
                 <artifactId>guava</artifactId>
                 <version>23.5-jre</version>
             </dependency>
         </dependencies>
         
     </project>
     ```
8. Just to make sure, reimport Maven. It will make sure your dependencies are downloaded to your local maven repository.
9. Create a `MyApplication` class
    - Add the following code:
    ```
        public static void main(String[] args) {
            ArrayList<String> helloWorld = Lists.newArrayList("Hello", " World");
            System.out.println(helloWorld.get(0) + helloWorld.get(1));
        }
    ```
    - Lists is a Guava class, you should be able to import it (thanks to Maven) to resolve the compilation error! 

There you have it, Maven is managing our external dependencies.
Go to codelab02 to find out how Maven also allows for compiling, packaging and executing our code, 
making our developer's life more easy.