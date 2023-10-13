package javas.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

public class Client {

    public static void main(String[] args) {
        Pair<String, String> p1 = new Pair<>("Sudha", "Maurya");
        String first = p1.getFirst();
        String second = p1.getSecond();
        System.out.println(first+" "+second);

        Pair<Integer, String> p2 = new Pair<>(100, "Maurya");
        int iFirst = p2.getFirst();
        String sSecond = p2.getSecond();
        System.out.println(iFirst+": "+sSecond);

        Pair p3 = new Pair("Hello", "World"); // raw type
        String p3First = (String) p3.getFirst(); // additional type casting needed
//        Integer p3Second = (Integer) p3.getSecond(); // this throws run time error, but it's not captured at compile time

        Animal a1 = new Animal("Cat", "White", 1);
        Animal a2 = new Animal("Cow", "Brown", 10);
        Animal a3 = new Animal("Camel", "Cream", 15);

        Pair<Animal, Integer> animalPair = new Pair<>();
        animalPair.printFirsts(List.of(a1, a2, a3));

        Dog d1 = new Dog("Dog1", "Brown", 1, true);
        Dog d2 = new Dog("Dog2", "White", 2, true);
        Dog d3 = new Dog("Dog3", "Black", 3, false);

        animalPair.printFirsts(List.of(a1, a2, d1, d2)); // this works because Dog is Animal

        List<Animal> animalList = List.of(a1, a2, a3);
        List<Animal> mixedList = List.of(a1, a2, d1, d2);
        List<Dog> dogList = List.of(d1, d2, d3);
        // List<Animal> animalList1 = dogList; java.util.List<javas.Generics.Dog> cannot be converted to java.util.List<javas.Generics.Animal>
        List<? extends Animal> animalList2 = dogList; // this works because of wild card

        animalPair.printFirsts(animalList);
        animalPair.printFirsts(mixedList);
        // animalPair.printFirsts(dogList); this won't work because List<Dog> is not really List<Animal>
        // animalPair.printFirsts(animalList2); java.util.List<capture#1 of ? extends javas.Generics.Animal> cannot be converted to java.util.List<javas.Generics.Animal>

        animalPair.printFirstsWithExtends(animalList);
        animalPair.printFirstsWithExtends(mixedList);
        animalPair.printFirstsWithExtends(dogList); // this works because parameter accepts anything that extends Animal.
        animalPair.printFirstsWithExtends(animalList2); // this works because of wild card

        List<? extends Animal> l1 = new ArrayList<Dog>(); // this is allowed
        // List<Animal> l2 = new ArrayList<Dog>(); // this is not allowed because we only want Animal in l2

        Map<String, String> myMap = new HashMap(); // Unchecked assignment: 'java.util.HashMap' to 'java.util.Map<java.lang.String,java.lang.String>'

        Map map = new HashMap();
        map = myMap;
        myMap = map; // Unchecked assignment: 'java.util.Map' to 'java.util.Map<java.lang.String,java.lang.String>'

        // Target types
        List<String> listOne = animalPair.emptyList(); // List<String> is target type
        List<String> listTwo = animalPair.<String>emptyList(); // this is required in Java 7

        processStringList(animalPair.emptyList()); // works in java 8
        processStringList(animalPair.<String>emptyList()); // this is required in Java 7

        // Unbounded wildcard
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        printList1(li);
        printList1(ls);

        // list defined by List<? extends NaturalNumber> is not read-only in the strictest sense of the word,
        // but you might think of it that way because you cannot store a new element or change an existing element in the list.
        List<Dog> le = new ArrayList<>();
        List<? extends Animal> ln = le;
        // ln.add(new Animal("", "", 3));
    }

    static void processStringList(List<String> stringList) {
        // process stringList
    }

    public static <T> int countGreaterThan1(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            //if (e > elem)  // compiler error
                ++count;
        return count;
    }

    public static <T extends Comparable<T>> int countGreaterThan2(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

    public void someMethod(Number n) {}

    public void someInteger(Integer n) {}

    // Because for any concrete type A, List<A> is a subtype of List<?>, you can use printList to print a list of any type:
    public static void printList1(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }

    // It cannot print List<Integer>, List<String>, List<Double>, and so on, because they are not subtypes of List<Object>.
    public static void printList2(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    /*
    Write a generic method to count the number of elements in a collection that have a specific property
    (for example, odd integers, prime numbers, palindromes).
     */
}

