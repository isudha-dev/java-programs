package strings;

public class StringOp {

    // Concatenate the string with itself.
    // Delete all the uppercase letters.
    // Replace each vowel with '#'.
    public static void main(String[] args) {
        System.out.println(solve("AbcaZeoB"));
    }

    static String solve(String A) {

        A = A + A;
        A = A.replaceAll("[A-Z]", "");
        A = A.replaceAll("[aeiou]", "#");

        return A;
    }

}
