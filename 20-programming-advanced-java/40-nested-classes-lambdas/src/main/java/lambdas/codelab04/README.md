# java.util.function

## allMatches

Make a static method called allMatches:
- It should take a List of Strings and a functional interface that performs a test and returns a boolean
- It should return a new List of all the values that passed the test. 

Test it with several examples. E.g.:
- `List<String> shortWords = LambdaApplication.allMatches(words, s -> s.length() < 4);`
- `List<String> wordsWithB = LambdaApplication.allMatches(words, s -> s.contains("b"));`
- `List<String> evenLengthWords = LambdaApplication.allMatches(words, s -> (s.length() % 2) == 0);`

Just so you know: words is a List containing Strings.

## allMatches extended

Redo allMatches so it works on any List, not just on Strings. 
Verify that your examples from allMatches still work. But now, you should be able to also do things like this:
- `List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);`
- `List<Integer> bigNums = LambdaApplication.allMatchesExtended(nums, n -> n>500);`

## transformedList

Make a static method called transformedList:
- It should take a List of Strings and a functional interface which takes a String, does a manipulation and returns a String
- It should return a new List that contains the results of applying the manipulation of the func. interf. to each element of the original List. E.g.:
    - `List<String> excitingWords = LambdaApplication.transformedList(words, s -> s + "!");`
    - `List<String> eyeWords = LambdaApplication.transformedList(words, s -> s.replace("i", "eye"));`
    - `List<String> upperCaseWords = LambdaApplication.transformedList(words, String::toUpperCase);`
    
## transformedList extended

Redo transformedList so it works with generic types. Verify that your examples from transformedList still work.
But now, you should also be able to also do things like this:
- `List<Integer> wordLengths = LambdaApplication.transformedList(words, String::length);`

Notice above that we're passing in a List of Strings, but getting out a List of Integer. Make sure your
generic types support this idea.

