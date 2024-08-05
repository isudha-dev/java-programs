package interview.athenahealth;

import java.util.ArrayList;
import java.util.List;

public class test123 {

    public static void main(String[] args) {
        List<String> history = List.of("1112", "1111", "1211", "1111");
        slotWheels(history);
    }

    public static int slotWheels(List<String> history) {
        // Write your code here
        int n = history.size();
        int wheelCount = history.get(0).length();
        int sum = 0;

        for(int x = 0; x < wheelCount; x++){
            List<Integer> prevMaxNumber = new ArrayList<>();
            List<String> newHistory = new ArrayList<>();
            int maxForIteration = Integer.MIN_VALUE;

            for(int y = 0; y < n; y++){
                String s = history.get(y);
                int maxNum = Integer.MIN_VALUE;
                for(char c: s.toCharArray()){
                    int i = Integer.valueOf(String.valueOf(c));
                    maxNum = Math.max(maxNum, i);
                }
                prevMaxNumber.add(maxNum);
                newHistory.add(y, s.replaceFirst(String.valueOf(maxNum), ""));
            }
            for(int i: prevMaxNumber){
                maxForIteration = Math.max(maxForIteration, i);
            }
            sum += maxForIteration;
            history = newHistory;
        }

        return sum;

    }
}
