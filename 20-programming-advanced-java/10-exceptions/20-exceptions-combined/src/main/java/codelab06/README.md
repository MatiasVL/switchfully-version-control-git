# File reading

Whenever we need to deal with reading in files (which shouldn't be often), we will have to deal with a lot of potential 
unsafe methods. 

Files are resources which are external to our application. This involves "risk", as these files might be moved, deleted,
locked, corrupted or other states. If our application tries to access a file which is missing or in a unfavorable state, 
our application will be unable to to do so... resulting in an exception being thrown.

Java SE comes with the `java.io` and `java.nio` packages which contain classes and other code that allows us 
(among other things) to read, write and create files. These classes come with a lot of checked exceptions. Thus, we are
forced to deal with those exceptions.

Throughout this codelab, we will provide you with code snippets for you to use and combine. We will also provide you
with some additional online resources for you to explore.

Do know that we do not require you to have a complete knowledge on **File I/O** (Input / Output). It's just a very 
convenient subject for when we want to learn how to work with exceptions.

## Let's start simple

Reading (and writing to) files can become difficult. Luckily, when working with small files, we can keep it 
rather simple.

If you have a small-ish file and you would like to read its entire contents in one pass, you can use the 
`readAllLines(Path)` method. This method takes care of most of the work for you, 
such as opening and closing the stream, but are not intended for handling large files. The following code shows 
how to use the readAllLines method:

```
Path pathToFile = ...;
List<String> lines = Files.readAllLines(pathToFile);
```
> Read more on https://docs.oracle.com/javase/tutorial/essential/io/file.html (Scroll down to "Commonly Used Methods for Small Files")


### Implement the read method

Go to the `MyFileReader` class, and implement the `read(String)` method so that it opens and reads in the lines of 
the provided filename (argument).

Base yourself on the following snippet:
```
Path pathToFile = ...;
List<String> lines = Files.readAllLines(pathToFile);
```

For the `pathToFile`, use the following code (which will create the correct path for the provided filename):
```
Path path = Paths
                .get(Paths.get(getClass().getResource(fileName).toURI())
                .toString());
```

Then, loop over the list of lines (`lines`) and print out every line to the console.

Make sure to:
- Deal with any checked exceptions in order to let your code compile successfully!
- Read the documentation of the different methods you're using, especially on `Files.readAllLines(...)`
    - https://docs.oracle.com/en/java/javase/11/ or https://docs.oracle.com/en/java/javase/12/

Finally, inspect and run `ReaderApplication`. The output should be as follows:
```
This
Is
The
Life
========================
5,2,3,4,1
2,4,5,2,0
1,1,1,2,3
```

> There are two sample files available, they're located in the `src/main/resources` folder, under pakcage `codelab06`. 
The `resources` folder is the standard folder (by convention) for storing resources (such as files, images,...)

- After successfully running the ReaderApplication, add the following line to the `main method`:
    - `myFileReader.read("NON_EXISTING_FILE.txt");`
- Rerun the code. What type of exception was thrown? Is it caught?

## Some additional theory

So, some additional theory. See this as a "good-to-know-bonus" section for when you ever need to work with files or other external resources.

The moment we're dealing with bigger files, we need to step-up our game, luckily Java SE offers the right tools for the job.

The `java.nio.file` package supports channel I/O, which moves data in buffers, bypassing some of the layers that can 
bottleneck stream I/O.
> Read more on https://docs.oracle.com/javase/tutorial/essential/io/file.html (Scroll down to "Buffered I/O Methods for Text Files")

We provide you with a fully working method, copy/paste it into your `MyFileReader` class if you like:
```Java
void readFile(String fileName) throws URISyntaxException {

    Path path = Paths.get(Paths.get(getClass().getResource(fileName).toURI()).toString());

    BufferedReader reader = null;

    try {
        reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException x) {
        System.err.format("IOException: %s%n", x.getMessage());
    } finally {
        if(reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.format("Failed to close BufferedReader: %s%n", e.getMessage());
            }
        }
    }
}
```

As you can see, there's a lot of exception handling involved. More importantly, take a good look at the `finally` statement.
Whatever happens, we have to close our `BufferedReader`. Always! If we don't, memory leaks might occur, 
resulting in our program slowing down and potentially crash because of being out of memory.
- Documentation of `close`: "*Closes the stream and releases any system resources associated with it.*"

This opening and closing of so-called resource streams or connections is a very common concept when accessing external 
resource such as files or database. Because of this, Java (since Java 7) offers a cleaner and better way of dealing with this: `try-with-resource`!
- https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

Below, you'll find a snippet that does the exact same thing as the previous snippet (it closes the stream as well), but this time,
we use the `try-with-resources` statement instead of the `try` statement.

```Java
void readFileClean(String fileName) throws URISyntaxException {

    Path path = Paths.get(Paths.get(getClass().getResource(fileName).toURI()).toString());

    try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException x) {
        System.err.format("IOException: %s%n", x);
    }
}
```

So... Much... Better!

**Should you work with external resources such as files, always opt for the `try-with-resources` statement (instead of `try`).**

