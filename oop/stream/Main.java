package oop.stream;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = List.of(12,23,454,21,36,34,56,1,4,45,123,454,456,867,12,45,66,23,23,765,56,34,56,1,4,45,56);
//        intList.forEach(i -> System.out.println(i));
        intList.forEach(System.out::println); // method reference -> dont need Consumer anonymous class and saves memory

        // filter
        intList
            .stream()
            .filter(i -> i > 100)
            .forEach(System.out::println);

        // map
        intList
            .stream()
            .map(Math::sqrt)
            .forEach(System.out::println);

        // reduce
        Optional<Integer> sumList = intList
            .stream()
            .reduce((acc, curr) -> acc+curr);

        // reduce with identity
        System.out.println(sumList.get());

        var sumList1 = intList
            .stream()
            .reduce(100, Integer::sum);

        System.out.println(sumList1);

        System.out.println("=============================");

        // parallel - multiple threads are spawned for performing - 1 main and many worker threads (same as no of core in your CPU)
        intList.stream()
            .parallel().forEach(i-> System.out.println(Thread.currentThread().getName()+": "+i));

        System.out.println("=============================");

        intList.stream().parallel()
                .map(i -> {
                    System.out.println(Thread.currentThread().getName()+": "+i);
                    return i;
                })
                .sequential()
                .map(i -> {
                    System.out.println(Thread.currentThread().getName()+": "+i);
                    return i;
                })
                .forEach(i -> {
                    System.out.println(Thread.currentThread().getName()+": "+i);
                });


        // sequential
        intList.stream()
            .parallel().sequential().forEach(System.out::println);
    }

}
