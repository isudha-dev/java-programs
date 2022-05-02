public class MyUtils {

    public static boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(int i) {
        return i % 2 == 0;
    }

    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    public static long findDecimalPlace(long num) {

        int i = 1;
        long mod = num % i;

        while (mod != num) {
            i *= 10;
            mod = num % i;

        }

        return i / 10;
    }

    public static boolean isArmstrongNum(long num) {
        long temp = num;
        long places = MyUtils.findDecimalPlace(num);

        int k = (int) Math.log10(places);
        long[] digits = new long[k + 1];

        int idx = 0;

        while (places >= 1) {
            long m = num / places;
            digits[idx] = m;
            idx++;

            num = num - m * places;
            places /= 10;

        }

        long sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += (Math.pow(digits[i], 3));
        }
        if (sum == temp) {
            return true;
        } else
            return false;
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {

        if (start == end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarySearch(nums, target, start, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, end);
        }

    }

    static int modifiedBinarySearch(int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start / 2) + (end / 2);
        if (isBadVersion(mid)) {
            return modifiedBinarySearch(start, mid);
        } else {
            return modifiedBinarySearch(mid + 1, end);
        }
    }

    static boolean isBadVersion(int num) {
        System.out.println(num);
        if (num >= 1702766719) {
            return true;
        } else
            return false;
    }

    public static int binarySearchWithPosition(int[] nums, int target, int start, int end) {

        if (start >= end) {
            if (nums[start] > target) {
                return start;
            } else {
                return start + 1;
            }
        }
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarySearchWithPosition(nums, target, start, mid - 1);
        } else {
            return binarySearchWithPosition(nums, target, mid + 1, end);
        }

    }

}
