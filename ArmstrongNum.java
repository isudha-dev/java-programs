import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArmstrongNum {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int range = scn.nextInt();
        scn.nextLine();
        scn.close();

        List<Long> allArmstrongNums = new ArrayList<Long>();

        for (Long i = (long) 1; i <= range; i++) {
            if (MyUtils.isArmstrongNum(i)) {
                allArmstrongNums.add(i);
            }
        }

        for (long l : allArmstrongNums) {
            System.out.println(l);
        }
    }

}
