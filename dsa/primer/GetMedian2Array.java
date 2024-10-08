package dsa.primer;

public class GetMedian2Array {

    // [1,2,4,5,7] -> Median is middle value i.e. 4
    // [1,4,7,8,10,15] -> Median is (sum of middle values) /2 -> 15/2 -> 7.5
    // array is always sorted
    // now consider two dsa.arrays and both are sorted. Find median. Answer should be
    // exactly same as if it was single array with all the values sorted.
    public static void main(String[] args) {
        System.out.println(getMedian(new int[] { -5, 0, 1, 5, 9, 10, 11}, new int[] { -1, 1, 2, 6, 19 }));
    }

    static float getMedian(int[] A, int[] B) {
        int len = A.length + B.length;

        int targetIndex = len / 2;

        int index = 0;
        int p1 = 0, p2 = 0;
        float value = 0;
        float prevValue = 0;
        while (index <= targetIndex && p1 < A.length && p2 < B.length) {
            prevValue = value;
            if (A[p1] <= B[p2]) {
                value = A[p1];
                p1++;
            } else {
                value = B[p2];
                p2++;
            }
            if (len % 2 == 0 && index == targetIndex) {
                return  (value + prevValue) / 2;
            }
            index++;
        }

        while (index <= targetIndex && p1 < A.length) {
            prevValue = value;
            value = A[p1];
            p1++;
            index++;
        }

        while (index <= targetIndex && p2 < B.length) {
            prevValue = value;
            value = B[p2];
            p2++;
            index++;
        }

        if (len % 2 == 0) {
            return  (value + prevValue) / 2;
        }

        return value;
    }

}
