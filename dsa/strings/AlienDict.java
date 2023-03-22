package dsa.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AlienDict {

    public static void main(String[] args) {
        String[] str = new String[] { "vfnue", "vjqfp", "eghva", "ufaeo", "atyqz", "chmxy", "ccvgv", "ghtow" };

        ArrayList<String> al = new ArrayList<>(Arrays.asList(str));
        System.out.println(solve(al, "nbpfhmirzqxsjwdoveuacykltg"));
    }

    static int solve(ArrayList<String> A, String B) {

        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        for (char c : B.toCharArray()) {
            map.put(c, i);
            i++;
        }
        for (int j = 0; j < A.size() - 1; j++) {
            String curr = A.get(j);
            String next = A.get(j + 1);

            if (map.get(curr.charAt(0)) > map.get(next.charAt(0))) {
                return 0;
            } else if (map.get(curr.charAt(0)) < map.get(next.charAt(0))) {
                continue;
            } else {
                int cLen = curr.length();
                int nLen = next.length();

                if (cLen > nLen && curr.equals(next)) {
                    return 0;
                }
                for (int k = 1; k < Math.min(cLen, nLen); k++) {
                    if (map.get(curr.charAt(k)) < map.get(next.charAt(k))) {
                        break;
                    } else if (map.get(curr.charAt(k)) > map.get(next.charAt(k))) {
                        return 0;
                    }
                }
            }

        }

        return 1;
    }

}
