package strings;

import java.util.ArrayList;
import java.util.Arrays;

public class ToLowerCase {
    public static void main(String[] args) {

        System.out.println(
                to_lower(new ArrayList<Character>(Arrays.asList(new Character[] { 'S', 'c', 'A', 'L', 'E' }))));
    }

    static ArrayList<Character> to_lower(ArrayList<Character> A) {
        for (int i = 0; i < A.size(); i++) {
            if ('A' <= A.get(i) && A.get(i) <= 'Z') {
                int temp = (int) A.get(i) ^ ('a' - 'A');
                A.set(i, (char) temp);
            }
        }
        return A;
    }
}
