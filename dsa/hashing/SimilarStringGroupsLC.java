package dsa.hashing;

import java.util.ArrayList;
import java.util.HashMap;

//https://leetcode.com/problems/similar-string-groups/
// not working solution for some inputs
public class SimilarStringGroupsLC {

    public static void main(String[] args) {
        System.out.println( numSimilarGroups(new String[]{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"})); // koqnn, noqnk => 1
    }

    public static int numSimilarGroups(String[] strs) {

        int size = strs.length;
        int len = strs[0].length();

        ArrayList<HashMap<Integer, Character>> maps = new ArrayList<>();


        for(String s: strs){
            HashMap<Integer, Character> map = new HashMap<>();
            for(int i  = 0; i < len; i++){
                map.put(i, s.charAt(i));
            }
            maps.add(map);
        }

        HashMap<String, Integer> groupMap = new HashMap<>();
        int groupId= 0;

        for(int i = 0; i < maps.size()-1; i++){
            for(int j = i+1; j < maps.size(); j++){
//                if(groupMap.containsKey(strs[j])){
//                    groupMap.put(strs[i], groupMap.get(strs[j]));
//                    continue;
//                }
                if(strs[i].equals(strs[j])){
                    if(groupMap.containsKey(strs[i])){
                        groupMap.put(strs[j], groupMap.get(strs[i]));
                    } else {
                        groupId++;
                        groupMap.put(strs[i], groupId);
                        groupMap.put(strs[j], groupId);
                    }
                    break;
                }
                int diffCount = 0;
                int k = 0;
                while (k < len){
                    boolean check = maps.get(i).get(k) == maps.get(j).get(k);
                    if(!check){
                        diffCount++;
                    }
                    k++;
                }
                if(diffCount == 2){
                    // add to group id
                    if(groupMap.containsKey(strs[i]) && !groupMap.containsKey(strs[j])){
                        groupMap.put(strs[j], groupMap.get(strs[i]));
                    } else if(groupMap.containsKey(strs[j]) && !groupMap.containsKey(strs[i])) {
                        groupMap.put(strs[i], groupMap.get(strs[j]));
                    } else {
                        groupId++;
                        groupMap.put(strs[i], groupId);
                        groupMap.put(strs[j], groupId);
                    }

                }
            }
        }

        if(groupMap.size()!=size){
            int count = 0;
            for(String s: strs){
                if(!groupMap.containsKey(s)){
                    count++;
                }
            }
            return groupId+count;
        }
        return groupId;
    }
}
