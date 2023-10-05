Write an interactive Java program that provides these 2 features: 1 - Checks if two texts are anagrams of each other.

2- Out of all inputs to feature #1: provides all the anagrams for a given string.

Inputs to feature #1 do not need to persisted across multiple runs of your program.

The mode of interactivity is not important. Choose what's easiest and quickest for you, a simple CLI interface is enough.

For feature #1:

Please follow the definition described in the english wikipedia page for anagram.

For feature #2:

- Given these hypothetical invocations of the feature#1 function -> f1 (A, B), f1(A, C), f1(A, D)

- *IF* A, B and D are anagrams

-f2(A) should return [B, D]

- f2(B) should return [A, D]

-f2(C) should return []

Feel free to use your favorite:

- IDE

- Language; the solution has to be either Java 8+ or Kotlin

- code hosting; the solution must be publicly accessible
----4e
- You can prioritize however you like (performance, readability, extensibility, ...).

P.S. Googling is a good thing :-)


---------------------
## Solution

## Prerequisites
- Java 17
- Gradle / Gradle Wrapper

## Building and Running the Application

This Java application offers an interactive platform to verify whether two input texts are anagrams and to retrieve all anagrams of a provided string from previous inputs.

## Features

1. **Feature #1:** Determines if two supplied texts are anagrams, adhering to the definition on the English Wikipedia page for anagram.
2. **Feature #2:** Retrieves all the anagrams for a specified string from the texts inputted to feature #1.

## User Interaction

Upon launching, the application requests user input via the console:

- Press `1` to activate feature #1.
- Press `2` to activate feature #2.
- Press `E` to exit the application.

Any other inputs will prompt the user for a valid option again.

### Feature #1 Logic

1. The user is prompted to input two texts. Input validation is bypassed with the assumption that the user provides two valid texts, each containing at least one alphabetical character.
2. Every input text undergoes the following transformations:
   - All whitespaces are removed.
   - All punctuation signs are removed.
   - Text is converted to lowercase.
   - Characters are sorted alphabetically.

If the transformed strings are identical post-transformation, the texts are considered to be anagrams; if not, they're considered non-anagrams. The application then outputs the results correspondingly.

Simultaneously, all input texts are stored in a `HashMap<String, List<String>>`, where the key is the transformed string, and the value is a list of all user inputs that result in the same transformed string (the key).

### Feature #2 Logic

In feature #2, upon receiving a user input, the application employs the same transformation algorithm as in feature #1 and retrieves the corresponding list from the map based on the transformed text, thereby informing the user of all recognized anagrams of the input text, based on the inputs given during feature #1 execution.


## Build and run the project
The application can be executed via a Java compatible ide, or using CLIas following:
Execute from the project root directory the commands below:

```
./gradlew build
java -cp build/classes/java/main anagrams.Main
```