package interview.interview_milvik_bima;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    class Employee{
        List<Address> addresses;
        int age;

        public Employee(List<Address> addresses, int age) {
            this.addresses = addresses;
            this.age = age;
        }
    }

    class Address {
        String addressLine1;
        String addressLine2;
        public String city;
        Integer pincode;

        public Address(String addressLine1, String addressLine2, String city, Integer pincode) {
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.city = city;
            this.pincode = pincode;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "addressLine1='" + addressLine1 + '\'' +
                    ", addressLine2='" + addressLine2 + '\'' +
                    ", city='" + city + '\'' +
                    ", pincode=" + pincode +
                    '}';
        }
    }

    public void test() {
        List<Employee> employees = Arrays.asList(
                new Employee(Arrays.asList(
                        new Address("Street 1", "Area 1", "Bangalore", 560001),
                        new Address("Street 2", "Area 2", "Bangalore", 110001)
                ), 35),
                new Employee(Arrays.asList(
                        new Address("Street 3", "Area 3", "Mumbai", 400001),
                        new Address("Street 4", "Area 4", "Chennai", 600001)
                ), 42),
                new Employee(Arrays.asList(
                        new Address("Street 5", "Area 5", "Bangalore", 560002),
                        new Address("Street 6", "Area 6", "Kolkata", 700001)
                ),28)
        );

        List<Employee> list = employees.stream()
                .flatMap(employee -> employee.addresses.stream()
                        .filter(address -> address.city.equals("Bangalore"))
                        .map(address -> employee))
                .distinct()
                .collect(Collectors.toList());

        System.out.println("--------Address sorting List 1---------");
        list.stream().forEach(employee -> System.out.println(employee.addresses));

        List<Employee> list2 =  employees.stream()
                .filter(employee -> employee.addresses.stream()
                        .anyMatch(address -> "Bangalore".equals(address.city)))
                .collect(Collectors.toList());

        System.out.println("--------Address sorting List 2---------");
        list2.stream().forEach(employee -> System.out.println(employee.addresses));

        List<Employee> ageList1 = employees.stream().sorted((e1, e2) -> Integer.compare(e1.age, e2.age)).collect(Collectors.toList());

        System.out.println("--------Age sorting List 1---------");
        ageList1.stream().forEach(employee -> System.out.println(employee.age));

        List<Employee> ageList2 = employees.stream().sorted(Comparator.comparingInt(e -> e.age)).collect(Collectors.toList());

        System.out.println("--------Age sorting List 2---------");
        ageList2.stream().forEach(employee -> System.out.println(employee.age));
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }

    public static int[] selectionSort(int[] arr){
        // iterate n times.
        // each iteration find largest/ smallest element
        // place element found in step 2 at correct position (start at n-1 for largest, 0 for smallest)

        int n = arr.length;
        int lastIdx = n-1;
        while (lastIdx >= 0){
            int maxIdx = 0;
            for(int i = 0; i<= lastIdx; i++){
                if(arr[i] > arr[maxIdx]){
                    maxIdx = i;
                }
            }
            int temp = arr[lastIdx];
            arr[lastIdx] = arr[maxIdx];
            arr[maxIdx] = temp;
            lastIdx--;
        }
        return arr;
    }

    public static int[] bubbleSort(int[] A) {
        int l = A.length;
        for (int i = 0; i < l; i++) {
            int m = 0;
            int n = 1;
            boolean swapMade = false;
            while (n <= l - 1) {
                if (A[m] > A[n]) {
                    swapMade = true;
                    int temp = A[m];
                    A[m] = A[n];
                    A[n] = temp;
                }
                m++;
                n++;
            }
            if (!swapMade){
                break;
            }
        }
        return A;
    }

    public static int[] insertionSort(int[] A){
        int l = A.length;
        for(int i = 1; i<l; i++){
            int elem = A[i];
            int j = i-1;
            while (j >= 0 && A[j] > elem){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = elem;
        }

        return A;
    }

    private static int countFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }


}
