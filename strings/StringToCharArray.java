package strings;

public class StringToCharArray {
    public static void main(String[] args) {
        int[] charArr = new int[58];
        String str = "Az1ZcBoPaAcB";
        for (Character c : str.toCharArray()) {
            System.out.println(c - 'A');
            int idx = c - 'A';
            if (idx >= 0 && idx <= 57)
                charArr[idx]++;
        }
        System.out.println(charArr);
    }

}
