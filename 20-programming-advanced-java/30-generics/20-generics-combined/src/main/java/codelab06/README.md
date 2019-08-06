 # SimpleList

You're going to create your own `List<E>` implementation named `SimpleList<E>`.
- It will be a bit like a very simplistic and broken `ArrayList<E>` implementation

`SimpleList<E>` should implement `List<E>`. You'll see you will have to implement a lot of methods. 
`SimpleList<E>` is only concerned with the `add`, `get` and `size` method. All other methods can be left unimplemented *(therefore, our `SimpleList<E>` is broken, but let's not bother too much about it)*.

The only thing we want to do is create instances of `SimpleList<E>` to which we can add elements and then access them as well.
- Tip: generally, a list stores its elements in an array. If the array is full, a new array is created and all the values are copied over.

## Usage

We should be able to use the `SimpleList<E>` as follows (test this!):
```
List<String> simpleListStrings = new SimpleList<>();
simpleListStrings.add("Hello");
simpleListStrings.add("World");
String shouldHoldHello = simpleListStrings.get(0);
int theSizeShouldBe2 = simpleListStrings.size();
```
or
```
List<Integer> simpleListInts = new SimpleList<>();
simpleListInts.add(5);
simpleListInts.add(6);
Integer shouldHold6 = simpleListInts.get(1);
```