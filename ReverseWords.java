public class ReverseWords {
    // Input: s = "Let's take LeetCode contest"
    // Output: "s'teL ekat edoCteeL tsetnoc"

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String output = reverseWords(s);
        System.out.println(output);
    }

    static String reverseWords(String s) {

        char[] chArray = s.toCharArray();
        int i = 0;
        int j;
        while (i < chArray.length) {
            j = i;
            while (chArray[j] != ' ') {
                j++;
                if (j == chArray.length) {
                    break;
                }
            }
            reverseWord(chArray, i, j - 1);
            i = j + 1;
        }

        return String.valueOf(chArray);
    }

    static char[] reverseWord(char[] word, int start, int end) {

        while (start < end) {
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            start++;
            end--;
        }
        return word;
    }

}
