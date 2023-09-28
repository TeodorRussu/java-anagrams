package anagrams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EngineTest {
    private Engine engine;

    @BeforeEach
    void setUp() {
        engine = new Engine();
    }

    @Test
    void test_singleWordAnagrams() {
        var word = "ABC";
        var anagram = "CBA";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_singleWordAnagrams_LowerOrUpperCase() {
        var word = "ABC";
        var anagram = "cbA";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_multiWordAnagrams_similarWordsCount() {
        var word = "AA BB";
        var anagram = "AB AB";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_multiWordAnagrams_similarWordsCount_lowerOrUpperCase() {
        var word = "AA BB";
        var anagram = "ab aB";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_multiWordAnagrams_distinctWordsCount() {
        var word = "AA BB CC";
        var anagram = "ABC ABC";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_multiWordAnagrams_distinctWordsCount_lowerOrUpperCase() {
        var word = "AA BB CC";
        var anagram = "abc cba";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_multiWordToSingleWordAnagrams() {
        var word = "AA BB CC";
        var anagram = "AACCBB";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_multiWordToSingleWordAnagrams_lowerOrUpperCase() {
        var word = "Aa BB Cc";
        var anagram = "AAccbb";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_multiWordToSingleWordAnagrams_samePunctuation() {
        var word = "Aa, BB, Cc";
        var anagram = "AA, cc, bb";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_multiWordToSingleWordAnagrams_differentPunctuation() {
        var word = "A:a, B'B; C-c!";
        var anagram = "AAcc, b;b.";

        Assertions.assertTrue(engine.areExpressionsAnagrams(word, anagram));
    }

    @Test
    void test_storeFeature1InputData_andUseItForFeature2() {
        // simulate feature 1 core logic
        var input1 = "AAABBB";
        var input2 = "aaabbb";
        engine.areExpressionsAnagrams(input1, input2);

        var input3 = "aaa-bbb";
        var input4 = "aa!ab!bb";
        engine.areExpressionsAnagrams(input3, input4);

        // simulate feature 2 core logic: found anagrams for the given string
        var existingAnagrams = engine.findExistingAnagramsInDataStore("AA BB AB");
        Assertions.assertTrue(existingAnagrams.contains(input1));
        Assertions.assertTrue(existingAnagrams.contains(input2));
        Assertions.assertTrue(existingAnagrams.contains(input3));
        Assertions.assertTrue(existingAnagrams.contains(input4));

        // simulate feature 2 core logic: not found anagrams for the given string
        var input5 = "aaa-bbb";
        var input6 = "xxx";
        engine.areExpressionsAnagrams(input5, input6);
        existingAnagrams = engine.findExistingAnagramsInDataStore(input6);
        Assertions.assertTrue(existingAnagrams.isEmpty());
    }
}