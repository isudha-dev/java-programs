package dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class ZAlgo {
    public static void main(String[] args) {
        String s = "";
        zAlgo(s);
    }

    public static List<Integer> zAlgo(String s){
        int n = s.length();
        List<Integer> ans = new ArrayList<>(n);
        ans.add(0, n);
        int L = 0, R = 0;
        for(int i = 1; i<n ;i++){
            if (i > R) {
                // brute force
                int j = 0, k = i;
                while(k<n && s.charAt(j) == s.charAt(k)){
                    j++;
                    k++;
                }
                ans.add(i, j);
                L = i; R = i+j-1;
            } else {
                if(ans.get(i-L) < R-i+1){
                    ans.add(i, ans.get(i-L));
                } else {
                    int j = R-i+1, k = R+1;
                    while(k<n && s.charAt(j) == s.charAt(k)){
                        j++;
                        k++;
                    }
                    ans.add(i, j);
                    L = i; R = i+j-1;
                }
            }
        }
        return ans;
    }
}
