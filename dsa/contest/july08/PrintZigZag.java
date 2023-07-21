package dsa.contest.july08;

public class PrintZigZag {

    public static void main(String[] args) {
        int n = 4;

//        Scanner scn = new Scanner(System.in);
//        n = scn.nextInt();

        String s = "111";
        if(n == 1){
            System.out.println(s);
        } else {

            for(int t = 2; t <= n; t++) {
                StringBuilder sb = new StringBuilder();
                sb.append(t);
                sb.append(s);
                sb.append(t);
                sb.append(s);
                sb.append(t);
                s = sb.toString();
                System.out.println(s);
            }
        }


    }

}
