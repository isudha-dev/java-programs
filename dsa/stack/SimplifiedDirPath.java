package dsa.stack;

import java.util.Stack;

public class SimplifiedDirPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }

    public static String simplifyPath(String A) {

        Stack<String> dir = new Stack<>();
        A.replace("//", "/");
        String[] paths = A.split("/");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!dir.isEmpty()) {
                    dir.pop();
                }
                continue;
            }
            if (s.equals(".") || s.equals("")) {
                continue;
            }
            dir.push(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!dir.isEmpty()) {
            // sb.append("/");
            // sb.append(dir.pop());

            sb.insert(0, dir.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0) {
            return "/";
        }

        return sb.toString();
    }

}
