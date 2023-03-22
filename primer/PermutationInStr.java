package primer;

public class PermutationInStr {

    public static void main(String[] args) {
        System.out.println(checkInclusion("a", "ab"));
    }

    static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 == 0) {
            return true;
        }
        if (l2 < l1) {
            return false;
        }

        int[] countMap = new int[26];
        int count0 = 0;

        // create the first window with all elements of s1 and s2
        // mark 1 for s1 alphabets and mark -1 for s2 alphabets
        // if an alphabet is present in both s1 and s2, it gets marked 0
        for (int i = 0; i < l1; i++) {
            countMap[s1.charAt(i) - 'a']++;
            countMap[s2.charAt(i) - 'a']--;
        }

        // mark 0 for all the alphabets that are not present in first window
        for (int i = 0; i < 26; i++) {
            if (countMap[i] == 0) {
                count0++;
            }
        }

        // if all the alphabets are 0, this indicates s1 has all alpha of s2
        if (count0 == 26) {
            return true;
        }

        // here we add 1 alpha from s2 and remove 1 alpha at the same time, to keep
        // window length same

        for (int i = l1; i < l2; i++) {
            // adding new element in window
            int r = s2.charAt(i) - 'a';
            countMap[r]--;
            if (countMap[r] == 0) {
                count0++;
            } else if (countMap[r] == -1) {
                count0--;
            }

            // removing older alpha from window
            // we keep lenght of window as l1, by removing i-l1 element
            int l = s2.charAt(i - l1) - 'a';
            countMap[l]++;
            if (countMap[l] == 0) {
                count0++;
            } else if (countMap[l] == 1) {
                count0--;
            }

            if (count0 == 26) {
                return true;
            }

        }

        return false;
    }

}
