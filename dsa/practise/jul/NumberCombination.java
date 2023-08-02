package dsa.practise.jul;

import java.util.ArrayList;
import java.util.List;

public class NumberCombination {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if( k > n || k < 0){
            return result;
        }

        if(k == 0){
            result.add(new ArrayList<>());
            return result;
        }

        if(k == n){
            List<Integer> listTemp = new ArrayList<>();
            for(int i = 1; i<=n; i++){
                listTemp.add(i);
            }
            result.add(listTemp);
            return result;
        }

        result = combine(n-1, k-1);
        for (List<Integer> list: result){
            list.add(n);
        }
        result.addAll(combine(n-1,k));

        return result;
    }

}
