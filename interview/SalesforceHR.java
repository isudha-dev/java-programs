package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class SalesforceHR {

    public static void pairs(int s, List<List<Integer>> matrix){
        int count = 0;

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        List<Set<Integer>> rowSets = new ArrayList<>();
        List<HashMap<Integer, Integer>> rowFreqMaps = new ArrayList<>();

        for(int r = 0; r < rows; r++){
            Set<Integer> rowSet = new HashSet<>();
            rowSets.add(rowSet);

            HashMap<Integer, Integer> rowFreqMap = new HashMap<>();
            rowFreqMaps.add(rowFreqMap);
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                rowSets.get(r).add(matrix.get(r).get(c));
                rowFreqMaps.get(r).put(matrix.get(r).get(c), rowFreqMaps.get(r).getOrDefault(matrix.get(r).get(c), 0)+1 );
            }
        }

        for(int r = 0; r < rows - 1; r++){
            for(int i : rowSets.get(r)){
                int freqI = rowFreqMaps.get(r).get(i);
                int j = s - i;
                for(int k = r+1; k < rows; k++){
                    if(rowSets.get(k).contains(j)){
                        int freqJ = rowFreqMaps.get(k).get(j);
                        count = count+(freqI*freqJ);
                    }
                }

            }

        }


        System.out.println(count);
    }

    public static String rearrangeWord(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        char[] chArr = word.toCharArray();

        // find 'index' where chArr[i-1] < chArr[i] => index = i-1
        int index = -1;
        for(int i = n-1; i>0; i--){
            if(chArr[i-1] < chArr[i]){
                index = i-1;
                break;
            }
        }

        if(index == -1) {
            return "no answer";
        }

        // from index+1 -> n-1 find next bigger letter, lets say 'idx'
        int idx = index+1;
        for(int i = idx; i<n; i++){
            if(chArr[i] > chArr[index] && chArr[i] <= chArr[idx]){
                idx = i;
            }
        }

        // swap chArr[index] with chArr[idx]
        char temp = chArr[index];
        chArr[index] = chArr[idx];
        chArr[idx] = temp;

        // rearrange chars from index+1 -> n-1 in ascending order
        String tempStr1 = new String(chArr).substring(0,index+1);
        String tempStr2 = new String(chArr).substring(index+1,n);
        char[] arrTempStr2 = tempStr2.toCharArray();
        Arrays.sort(arrTempStr2);

        sb.append(tempStr1);
        sb.append(new String(arrTempStr2));
        return sb.toString();

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();
        scn.nextLine();

        String[] wordArr = new String[count];

        for(int i = 0; i< count; i++){
            wordArr[i] = scn.nextLine();
        }

        for(int i = 0; i< count; i++){
            System.out.println(rearrangeWord(wordArr[i]));
        }

        System.out.println( rearrangeWord("dcba"));

        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(List.of(1,0,1)));
        matrix.add(new ArrayList<>(List.of(-1,2,1)));
        matrix.add(new ArrayList<>(List.of(2,2,1)));
        pairs(3, matrix);

    }

}
