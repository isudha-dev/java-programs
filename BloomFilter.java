public class BloomFilter {

    public static void main(String[] args) {
        trimMobileNum(867342516);

    }

    static boolean filterRead(int mobileNum) {

        return false;
    }

    static void filterWrite(int mobileNum, boolean dnd) {
        // assuming mobileNum 4 digit prefixes are same for single provide, hence
        // removing it

    }

    static long trimMobileNum(long mobileNum) {

        long[] newNum = new long[6];
        int idx = 0;

        while (mobileNum > 0) {
            newNum[idx] = mobileNum % 10;
            mobileNum = mobileNum / 10;
            idx++;
        }

        return 0;
    }

    static long trimNew(Long mobileNum) {

        long[] newNum = new long[6];
        int idx = 0;

        while (mobileNum > 0) {
            newNum[idx] = mobileNum % 10;
            mobileNum = mobileNum / 10;
            idx++;
        }

        return 0l;
    }

}
