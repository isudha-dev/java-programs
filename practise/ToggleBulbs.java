package practise;

public class ToggleBulbs {

    public static void main(String[] args) {

    }

    public static int toggleBulb(int[] bulbs) {
        int toggleSoFar = 0;
        int totalToggle = 0;

        for (int i = 0; i < bulbs.length; i++) {
            if (bulbs[i] == 0) {
                if (toggleSoFar % 2 == 0) {
                    totalToggle++;
                }
            } else {
                if (toggleSoFar % 2 == 1) {
                    totalToggle++;
                }
            }
        }

        return totalToggle;

    }

}
