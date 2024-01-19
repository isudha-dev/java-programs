package concepts;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Hashing {

    /*
        Hashtable implementation -
        Capacity: Size of hash table. i.e. number of values stored in hash table
        Initial capacity: Starting Hashtable with some capacity. Default - 16
        Load factor: A factor which is used to determine if capacity of Hashtable should be updated. This will trigger rehash of existing values. Default - 0.75
        Capacity is doubled if 75% of the hash table gets occupied.

        Hashtable is thread-safe, while HashMap is not thread-safe and is ideal for un-synchronized and single threaded application only.
        We can implement locking/sync mechanism to make HashMap thread-safe.
        Hashtable is deprecated from Java 8, we should consider using ConcurrentHashMap in multithreaded requirements.

        HashMap allows 1 null key and multiple null values.
        Hashtable does not allow null for keys and values.

        Collision handling -
        1. Separate chaining: supports creating linked list in buckets of a Hash table. i.e. array of linked list, where array index is hash value.
        2. Linear probing: selecting first available bucket, after determined one, that has free memory bucket.
        3. Resize and Copy: resize the hash table and redistribute data on it.
        If there are 8 or more entries in a bucket, it's changed to balanced tree from singly linked list. And changed back to ll if size is 6 or less.

        HashMap uses Iterator, while Hashtable uses Enumerator to iterate over values.
        Iterator is successor of Enumerator and eliminates few drawbacks. E.g. Iterator allow removal of elements.

        Fail-fast vs Fail-safe iterator -
        1. Fail-fast iterator throws exception when underlying collection is modified while iterating. E.g. HashMap, Hashtable, ArrayList etc.
            Throws ConcurrentModificationException
        2. Fail-safe iterator is weakly consistent and may not throw exception when underlying collection is modified while iterating. E.g. ConcurrentHshMap etc.


     */

    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();

        Enumeration<Integer> enumKey = table.keys();
        Collection<String> enumVal = table.values();

        HashMap<Integer, String> map = new HashMap<>();

        Iterator<Map.Entry<Integer, String>> iteratorMap = map.entrySet().iterator();
        Iterator<String> iteratorValue = map.values().iterator();
        Iterator<Integer> iteratorKey = map.keySet().iterator();

        table.put(1, "Java");
        table.put(2, "Scala");
        table.put(3, "Python");
        table.put(4, "Ruby");
        table.put(5, "Java");

        List<Integer> ans = new ArrayList<>();

        // Java 8 introduction
        table.forEach((key, value) -> {
            if(Objects.equals(value, "Java")) {
                ans.add(key);
            }
        });

        System.out.println(ans);

        map.put(6, "C");
        map.put(7, "Java");
        map.put(8, "Java");

        map.forEach((key, value) -> {
            if(Objects.equals(value, "Java")) {
                ans.add(key);
            }
        });

        System.out.println(ans);
    }

}
