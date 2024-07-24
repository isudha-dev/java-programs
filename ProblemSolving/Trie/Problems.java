package ProblemSolving.Trie;

public class Problems {
    public static void main(String[] args) {
//        TrieNode dummy = new TrieNode();
//        CrudOps co = new CrudOps();
//        co.add(dummy,"tarun");
//        co.add(dummy, "tara");
//        co.add(dummy, "keshav");
//        co.add(dummy, "kesar");
//
//        System.out.println(co.search(dummy, "tarun"));
//
//        System.out.println(dummy);
        subUnsort(new int[] { 1, 3, 2, 4, 5});


    }

    public static int[] subUnsort(int[] A) {

        // 1, 3, 2, 4, 5, 7, 6, 8, 9
        int l = -1, r = -1;
        int n = A.length;
        for(int i = 1; i<n; i++){
            if(A[i-1] > A[i]){
                l = i-1;
                break;
            }
        }

        for(int i = n-2; i >= 0; i--){
            if(A[i+1] < A[i]){
                r = i+1;
                break;
            }
        }

        if(l == -1 && r == -1){
            return new int[] {-1};
        } else {
            int len = r - l + 1;
            int[] newArr = new int[len] ;
            for(int i = 0; i<len; i++ ){
                newArr[i] = A[l];
                l++;
            }
            return newArr;
        }
    }
}
