package dsa.practise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeat {

    public static int lengthOfLongestSubstring(String A) {
        if(A.length()==1){
            return 1;
        }
        char[] chArr = A.toCharArray();

        Queue<Character> queue = new LinkedList<>();
        int len = 0;
        HashSet<Character> set = new HashSet<>();

        for(char c: chArr){
            if(queue.isEmpty()){
                queue.add(c);
                set.add(c);
                len++;
                continue;
            }
            if(set.contains(c)){
                while (!queue.isEmpty() && queue.peek() != c){
                    Character r = queue.peek();
                    queue.remove();
                    set.remove(r);
                }
                queue.remove();
                set.remove(c);
            }
            queue.add(c);
            set.add(c);
            len = Math.max(len, set.size());

        }

        return len;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("AaaA");
    }


}
