package ProblemSolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Base62Converter {
    private static final String BASE62_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int
            BASE = BASE62_CHARS.length();

    public static String encodeToBase62(String input) {
        if (input == null || input.isEmpty())
            return "";

        StringBuilder encoded = new StringBuilder();

        // Convert string to bytes
        byte[] bytes = input.getBytes();

        // Convert bytes to numeric value
        long num = 0;
        for (byte b : bytes) {
            num = num * 256 + (b & 0xFF); // left shift by 8 to make space for next bytes to be added
        }

        // Convert numeric value to Base62
        while (num > 0) {
            System.out.println("Num: "+num);
            char c = BASE62_CHARS.charAt((int) (num % BASE));
            System.out.println("Char: "+c);
            encoded.insert(0, c);
            num /= BASE;
        }

        return encoded.toString();
    }

    public static String decodeFromBase62(String encoded){

        long num = 1;
        char[] cArr = encoded.toCharArray();

        for(int i = 0; i<cArr.length; i++){
            int n = cArr[i];
            num *= BASE;
        }
        return "";
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String encoded = encodeToBase62(input);
        System.out.println("Encoded Base62 string: " + encoded);
        decodeFromBase62(encoded);
    }
}
