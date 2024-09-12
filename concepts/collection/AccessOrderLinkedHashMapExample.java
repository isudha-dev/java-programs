package concepts.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class AccessOrderLinkedHashMapExample {
    public static void main(String[] args) {
        // Create a LinkedHashMap with access order
        LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);

        // Add some entries
        accessOrderMap.put("A", 1);
        accessOrderMap.put("B", 2);
        accessOrderMap.put("C", 3);

        System.out.println("Initial order: " + accessOrderMap);

        // Access an entry
        accessOrderMap.get("A");

        System.out.println("Order after accessing 'A': " + accessOrderMap);

        // Add a new entry
        accessOrderMap.put("D", 4);

        System.out.println("Order after adding 'D': " + accessOrderMap);

        // Create a LinkedHashMap with access order and size limit (LRU cache)
        LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<String, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 3; // Limit cache size to 3
            }
        };

        lruCache.put("X", 10);
        lruCache.put("Y", 20);
        lruCache.put("Z", 30);
        System.out.println("LRU Cache: " + lruCache);

        lruCache.get("X"); // Access X, making it the most recently used
        lruCache.put("W", 40); // This will cause Y to be removed as it's now the least recently used

        System.out.println("LRU Cache after operations: " + lruCache);
    }
}
