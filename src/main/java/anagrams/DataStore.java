package anagrams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataStore {
    private static Map<String, Set<String>> data = new HashMap<>();

    public static void storeItem(String hash, String expression) {
        var items = data.getOrDefault(hash, new HashSet<>());
        items.add(expression);
        data.put(hash, items);
    }

    public static Set<String> findByHash(String hash) {
        return data.getOrDefault(hash, new HashSet<>());
    }
}
