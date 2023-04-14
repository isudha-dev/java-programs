package dsa.stack;

import java.util.Stack;

public class SimplifyPathLC {

    public static void main(String[] args) {

    }

    public String simplifyPath(String path) {
        path.replace("//", "/");
        Stack<String> stk = new Stack<>();

        String[] arr = path.split("/");
        for(String s: arr ){
            if(s.equals("..")){
                if(!stk.isEmpty()){
                    stk.pop();
                }
                continue;
            }
            if(s.equals(".") || s.equals("")){
                continue;
            }
            stk.push(s);
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()){
            sb.insert(0, stk.pop());
            sb.insert(0,"/");
        }

        if(sb.length() == 0){
            return "/";
        }

        return sb.toString();

    }

}
