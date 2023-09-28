package anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static anagrams.InputDataUtils.standardizeData;

public class Engine {

    public static final String EXIT = "Exit";
    public static final String F_1 = "F1";
    public static final String F_2 = "F2";
    public static final String NUMBER_1 = "1";
    public static final String NUMBER_2 = "2";
    public static final String CHARACTER_E = "E";
    private final Map<String, String> flows = Map.of(NUMBER_1, F_1, NUMBER_2, F_2, CHARACTER_E, EXIT);

    public void runApp() throws IOException {
        var continueExecution = true;
        System.out.println("+++++++++++");
        var reader = new BufferedReader(new InputStreamReader(System.in));

        while (continueExecution) {
            System.out.println("- If you want to check if 2 expression are anagrams, type '1' \n- If you want to look for stored anagrams for an expression, type '2' \n- If you want to exit, type 'E'");
            var selectedFlowInput = reader.readLine();

            var appFlow = flows.get(selectedFlowInput.trim());

            if (appFlow == null) {
                System.out.println("Invalid input. Try again!");
                continue;
            }
            if (appFlow.equals(EXIT)) {
                System.out.println("Shutting down!");
                continueExecution = false;
                continue;
            }

            if (appFlow.equals(F_1)) {
                runFlowAnagramsCheck(reader);
                continue;
            }

            if (appFlow.equals(F_2)) {
                runFlowFindAllAnagrams(reader);
            }
        }
    }

    private void runFlowAnagramsCheck(BufferedReader reader) throws IOException {
        System.out.println("Enter Expression 1");
        var firstText = reader.readLine();

        System.out.println("Enter Expression 2");
        var secondText = reader.readLine();

        var areAnagrams = areExpressionsAnagrams(firstText, secondText);
        System.out.println(String.format("The expressions are %s anagrams", areAnagrams ? "" : "not"));
    }

    private void runFlowFindAllAnagrams(BufferedReader reader) throws IOException {
        System.out.println("Enter Expression");
        var inputText = reader.readLine();

        var existingAnagrams = findExistingAnagramsInDataStore(inputText);
        if (existingAnagrams.isEmpty()) {
            System.out.println("\tNo anagrams found!");
            return;
        }

        System.out.println("\tThe following anagrams found!");
        existingAnagrams.forEach(System.out::println);
    }

    public boolean areExpressionsAnagrams(String firstExpression, String secondExpression) {
        var firstTextStandardized = standardizeData(firstExpression);
        var secondTextStandardized = standardizeData(secondExpression);

        // store data to be served in Feature 2
        DataStore.storeItem(firstTextStandardized, firstExpression);
        DataStore.storeItem(secondTextStandardized, secondExpression);

        return firstTextStandardized.equals(secondTextStandardized);
    }

    public Set<String> findExistingAnagramsInDataStore(String inputText) {
        System.out.println("\tLooking for anagrams for expression: " + inputText);

        var inputTextStandardized = standardizeData(inputText);
        return DataStore.findByHash(inputTextStandardized)
                .stream()
                .filter(item -> !item.equals(inputText))
                .collect(Collectors.toSet());
    }
}