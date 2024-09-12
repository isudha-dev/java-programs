package concepts.Generics;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Algorithm {

    // generic method to count the number of elements in a collection that have a specific property
    // (for example, odd integers, prime numbers, palindromes)
    public static <T> int countIf(Collection<T> c, UnaryPredicate<T> p){
        int count = 0;
        for(T e: c){
            if(p.test(e))
                count++;
        }
        return count;
    }

    // generic method to exchange the positions of two different elements in an array
    public static <T> void exchange(T[] arr, int p1, int p2){
        T temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    // generic method to find the maximal element in the range [begin, end) of a list
    public static <T extends Object & Comparable<? super T>> T maxElem(List<? extends T> list, int begin, int end){
        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;

    }

}
