package ProblemSolving.Heap;

import java.util.ArrayList;
import java.util.List;

public class SFTest {

    public static void main(String[] args) {
        // Q1
        List<Integer> arr = new ArrayList<>(List.of(4));
        getMinimumCost(arr);

        // Q2
        long startTime = System.nanoTime();
        getValidKeyCount(List.of(10l, 100000000000000l));
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeInMilliseconds = (double) elapsedTime / 1_000_000;
        System.out.println("Execution time in milliseconds: " + elapsedTimeInMilliseconds);
        // Execution time in milliseconds: 1148.853542
        // Execution time in milliseconds: 405.798667
    }

    public static List<Integer> getValidKeyCount(List<Long> keys) {
        // Write your code here
        // 4 : 1 2 4
        // 9 : 1 3 9
        // 5:  1 5 25
        // 49: 1 7 49
        // square(prime) <= keys

        Long max = keys.stream().reduce(Math::max).get();

        long numMax = (long) Math.sqrt(max) + 1;
        List<Long> primeSqaure = new ArrayList();

        // find all prime between 1 to numMax
        for(long i = 2; i <= numMax; i++){
            if(isPrime2(i)){
                primeSqaure.add(i*i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(Long num: keys){
            long count = primeSqaure.stream().filter(i -> i<=num).count();
            ans.add((int) count);
        }


        return ans;

    }

    public static boolean isPrime2(long number){
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        int i = 5;
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }

        return true;
    }

    public static boolean isPrime(long num){
        if(num <= 1){
            return false;
        }
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static long getMinimumCost(List<Integer> arr) {
        // Write your code here 4 4 9 64  16+16 = 32
        // 3 6 3 => 9 36 9 => 54 : 3 3 3 3 => 36
        // 4 7 7 => 3 0 => 9 => 4 5 7 7 => 1 2 0 => 1 + 4 => 5

        if(arr.size() == 1){
            return 0l;
        }

        int minSumIdx = 0; // i and i-1
        long maxSum = 0l;
        long squareSum = 0l;
        for(int i = 1; i< arr.size(); i++){
            long sum = (long) Math.abs(arr.get(i) - arr.get(i-1));
            if(sum > maxSum){
                minSumIdx = i;
                maxSum = sum;
            }
            squareSum = squareSum + (sum * sum);
        }

        long toSubstract = (long) Math.abs(arr.get(minSumIdx) - arr.get(minSumIdx-1));
        toSubstract *= toSubstract;

        long diff = (long) Math.abs(arr.get(minSumIdx) - arr.get(minSumIdx-1));
        long min = (long) Math.min(arr.get(minSumIdx), arr.get(minSumIdx-1));
        long max = (long) Math.max(arr.get(minSumIdx), arr.get(minSumIdx-1));
        long toAdd = (long) diff/2;
        long newElem = (long) (min + toAdd);

        long squareToAdd1 = (long) (newElem - min);
        squareToAdd1 *= squareToAdd1;
        long squareToAdd2 = (long) (newElem - max);
        squareToAdd2 *= squareToAdd2;

        squareSum = squareSum - toSubstract + squareToAdd1 + squareToAdd2;

        return squareSum;


    }

}
