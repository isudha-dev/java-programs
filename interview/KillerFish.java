package interview;

import java.util.Stack;

public class KillerFish {

    public static void main(String[] args) {
        int[] A = {20, 13, 10, 9, 1, 1, 16, 16, 7, 7} ;// {2,1,17,15,8}; //{16,3,3,6,7,8,17,13,7} // 20, 23, 10, 9, 1, 1, 16, 16, 7, 7
        String B = "RRLLRLLLLL"; //"RRLRL"; //  // RRLLRLLLLL
        System.out.println( solve(A, B));
    }

    public static int solve(int[] A, String B) {
        // using stack
        // if stack.top = r and new elem = l then fish will fight
        // so pop and do calculation
        // do this until stack.size == 1;

        Stack<Character> stkC = new Stack<>();
        Stack<Integer> stkI = new Stack<>();
        char[] chArr = B.toCharArray();

        for(int i = 0; i< A.length; i++){
            char c = chArr[i];
            int e = A[i];
            if(stkC.isEmpty()){
                stkC.push(c);
                stkI.push(e);
            }
            else {
                char topC = stkC.peek();
                int topI = stkI.peek();
                if(c == 'L' && topC == 'R'){
                    if(e == topI){
                        stkC.pop();
                        stkI.pop();
                    } else {
                        while(c == 'L' && topC == 'R' && !stkC.isEmpty() && !stkI.isEmpty()){
                            if(e == topI){
                                stkC.pop();
                                stkI.pop();
                                break;
                            } else if(e > topI) {
                                stkC.pop();
                                stkI.pop();
                            } else {
                                break;
                            }
                            if(!stkC.isEmpty()){
                                topC = stkC.peek();
                                topI = stkI.peek();
                            }
                        }
                        stkC.push(c);
                        stkI.push(e);
                    }


                } else if((c == 'R' && topC == 'R') || (c == 'L' && topC == 'L')) {
                    stkC.push(c);
                    stkI.push(e);
                }

            }
        }

        return stkC.size();

    }
}
