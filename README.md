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

- You can prioritize however you like (performance, readability, extensibility, ...).

P.S. Googling is a good thing :-)