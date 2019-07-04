# Length of Words

Using streams, create a method that accepts a String containing multiple words
that returns a String containing the amount of words per word length (from smallest to largest size).

This string should be formatted as ```amountOfLetters:numberOfWordsWithThatAmountofLetters```, separated by a comma.

Some test cases:
- given "test ok" should return "2:1, 4:1"
- given "uk ok gold go" should return "2:3, 4:1"
- given "blue black red transformation bed" should return "3:2, 4:1, 5:1, 14:1"