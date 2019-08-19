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
    E.g.: ```D:\apache-maven-3.6.1\bin```
5. Open up your command line / terminal and execute the ```mvn -v``` commando, you should get a similar-ish result:
    ```
    Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-04T21:00:29+02:00)
    Maven home: C:\Program Files\apache-maven-3.6.1\bin\..
    Java version: 12.0.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-12.0.1
    Default locale: en_US, platform encoding: Cp1252
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
    ```

## Dependency Management with Maven

1. Create a new Java project
    - In Intellij: ```File > New > Project > Java```
2. Create the following folder structure:
    ```
    simple-maven-project
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
    - Small remark: since the POM file is written in xml (`pom.xml`), the following optional XML-specific elements 
    and attributes are often added to the POM file (don't worry about them):
        - The XML declaration / prolog: `<?xml version="1.0" encoding="UTF-8"?>` specifies the version and encoding of the XML.
        - The XML namespace (and schema instance) are added as attributes to the `project` element.
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
                 <version>28.0-jre</version>
             </dependency>
         </dependencies>
         
     </project>
     ```
8. Just to make sure, reimport Maven. It will make sure your dependencies are downloaded to your local maven repository.
10. In Intellij look at the External Libraries tab
    - If everything worked correctly you should see the guava library files
11. Create a `MyApplication` class
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
