# ClassPath and Packaging 

We have created a small program that - given a github username as argument - generates the GitHub URL to view that user's profile.

Start by
1. Compiling the program using the `javac` tool (CMD).
2. Run the program using the `java` tool (CMD).
    - *Don't forget to provide a GitHub username as argument* 

## Mastering the ClassPath

> [Classpath][] is a parameter in the Java Virtual Machine or the Java compiler that specifies the location(s) of user-defined classes and packages. The parameter may be set either on the command-line (-cp), or through an environment variable (CLASSPATH).

[Classpath]: https://docs.oracle.com/javase/tutorial/essential/environment/paths.html

By now, you have run your program with the ```java GitHubLinkGenerator``` command about 1 or 2 times. 
If you have given it any thought, it is possible you were thinking that the command you were giving the JVM is to 
take the ```GitHubLinkGenerator.class``` file and execute it.
  
> **TASK 7:** Try running your program again, this time using the .class name:
> ```java GitHubLinkGenerator.class```

What's happening here? Clearly, writing "GitHubLinkGenerator" isn't shorthand for ```GitHubLinkGenerator.class```. 
What you are actually telling the JVM is: find me the Class (not class-file) with name ```GitHubLinkGenerator```, and run its main method. 
To find that Class, the JVM goes through the classpath, looking for any .class-file containing a Class called GitHubLinkGenerator. 
It dynamically (at runtime) loads that Class (and all of the Classes it depends on), and invokes its main method. 
Just now, you were telling it to load a Class ```GitHubLinkGenerator.class``` that doesn't exist.

Yet when you were trying to run the GitHubLinkGenerator class before, you weren't having any problems. 
That is because the current directory is implicitly part of the classpath.

> **TASK 8A:** Instead of running `java GitHubLinkGenerator <username>` in folder `(...)/pack-codelab01/src/main/java` 
Try running the same command from folder `(...)/pack-codelab01/src/main` (one level up).
- You should receive the following error:
```
Error: Could not find or load main class GitHubLinkGenerator
Caused by: java.lang.ClassNotFoundException: GitHubLinkGenerator
```

> **TASK 8B:** Stay at the `(...)/pack-codelab01/src/main` directory/folder. 
This time, use the classpath parameter of the java command to run your GitHubLinkGenerator program again. 
You will have to point the classpath to the directory where your GitHubLinkGenerator class is located. 
Look at the java -help (`java -help`). Search for options `--class-path` or `-cp` (shorthand form).

Ready? The correct command can be found below. Try it out.
```
java -cp "java" GitHubLinkGenerator MyUsername
```
- with `-cp "java"` we set folder "java" to the classpath
    - we use the relative path (relative from the current directory `main`).
        - If we would have executed the command from inside the `src` directory, it would have been `-cp "main/java"`.

## Java Archive (Jar)

A jar file is a collection of Java class files and resources (images, data, configs, ...) stored inside a zipped archive, 
together with a Manifest file that specifies things about its contents (like which class is the main class (the class holding the `main` method to execute)).

### Creating a Jar

We will create a jar that packages your single class file ```GitHubLinkGenerator.class```. 
To set this jar up to run our program when the jar is loaded, we need to create a manifest file containing the following line:

> Main-Class: GitHubLinkGenerator

In the `pack-codelab01` folder, create a `MANIFEST.MF` file.
In it, place the following line:
```
Main-Class: GitHubLinkGenerator
```
- Where `GitHubLinkGenerator` is the name of the Class that has a `main` method which you want to execute.
    - It's not the name of a `.class` file.

Finally, to create a jar we use the `jar` command line utility.
- jar files: https://docs.oracle.com/javase/tutorial/deployment/jar/index.html

From inside the `pack-codelab01` folder, open the terminal (CMD):
```
jar cvfm githublink.jar MANIFEST.MF -C "src/main/java/" GitHubLinkGenerator.class
```
- `c`: create a jar archive
- `v`: verbosely show the files being packaged
- `f`: write jar to a file
- `m`: read manifest from a file
- `githublink.jar`: filename of the jar
- `MANIFEST.MF`: filename of the manifest
- `-C` dir: root directory of files added to the jar
- `GitHubLinkGenerator.class`: the file(s) to add (could be multiple files and dirs) 

> **TASK 9:** Execute the above command

### Using a Jar

Once we have a jar, we can put it on the classpath to be able to use the classes that are located within (as a library of sorts). 
But in the case of your jar, where we have configured the Main class in its manifest, we can tell the JVM to run the jar as an application:
 
```
$ java -jar githublink.jar fakefreddy
https://github.com/fakefreddy
```
