package dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/similar-string-groups/
public class SimilarStringGroupsLC {

    public static void main(String[] args) {
        System.out.println( numSimilarGroups(new String[]{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"})); // koqnn, noqnk => 1
    }

    public static int numSimilarGroups(String[] strs) {
        List<List<Integer>> adjList = createAdjList(strs);
        boolean[] visited = new boolean[adjList.size()];
        int count = 0;
        for(int i = 0; i < strs.length; i++){
            if(!visited[i]){
                dfs(i, visited, adjList);
                count++;
            }
        }

        return count;
    }

    public static void dfs(int i, boolean[] visited, List<List<Integer>> adjList) {
        visited[i] = true;
        for(int j: adjList.get(i)){
            if(!visited[j]){
                dfs(j, visited, adjList);
            }
        }
    }

    public static List<List<Integer>> createAdjList(String[] strs){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i < strs.length; i++) {
            ans.add(new ArrayList<>());
        }
        for(int i = 0 ; i < strs.length - 1; i++){
            for(int j = i+1; j < strs.length; j++){
                if(isSimilar(strs[i],strs[j])){
                    ans.get(i).add(j);
                    ans.get(j).add(i);
                }
            }
        }

        return ans;
    }

    public static boolean isSimilar(String s1, String s2){
        int count = 0;
        int n = s1.length();
        for(int i = 0; i<n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        return count==0 || count==2;
    }
}
