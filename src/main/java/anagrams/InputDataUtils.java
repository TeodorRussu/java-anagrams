package anagrams;

import java.util.Arrays;

public class InputDataUtils {
    private InputDataUtils() {
    }

    public static String clearWhitespaces(String data) {
        return data.replaceAll("\\s+", "");
    }

    public static String clearPunctuationSigns(String data) {
        return data.replaceAll("\\p{Punct}", "");
    }

    private static String transformDataInSortedCharactersString(String dataLowerCased) {
        char[] chars = dataLowerCased.toCharArray();
        Arrays.sort(chars);
        return  String.copyValueOf(chars);
    }

    public static String standardizeData(String data) {
        var dataWithoutWhitespaces = clearWhitespaces(data);
        var dataWithoutPunctuation = clearPunctuationSigns(dataWithoutWhitespaces);
        var dataLowerCased = dataWithoutPunctuation.toLowerCase();

        return transformDataInSortedCharactersString(dataLowerCased);
    }

}
