public class Bulbs {
    // https://www.scaler.com/academy/mentee-dashboard/class/25589/assignment/problems/320?navref=cl_tt_nv

    /*
     * A wire connects N light bulbs.
     * 
     * Each bulb has a switch associated with it; however, due to faulty wiring, a
     * switch also changes the state of all the bulbs to the right of the current
     * bulb.
     * 
     * Given an initial state of all bulbs, find the minimum number of switches you
     * have to press to turn on all the bulbs.
     * 
     * You can press the same switch multiple times.
     * 
     * Note: 0 represents the bulb is off and 1 represents the bulb is on.
     */

    public static void main(String[] args) {
        System.out.println(bulbs(new int[] { 0, 1, 1, 1, 1, 0, 0, 1 }));

    }

    static int bulbs(int[] A) {

        int switch_pressed = 0;

        for (int i : A) {
            if (switch_pressed % 2 == 0) {
                if (i == 0) {
                    switch_pressed++;
                }
            } else {
                if (i == 1) {
                    switch_pressed++;
                }
            }
        }

        return switch_pressed;

    }

}
