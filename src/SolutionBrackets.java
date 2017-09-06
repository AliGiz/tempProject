import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionBrackets {

    public static boolean isBalanced(String expression) {
// Must be even
            char[] brackets = expression.toCharArray();
            Stack<Character> s = new Stack<>();
            for (char bracket : brackets)
                switch (bracket) {
                    case '{': s.push('}'); break;
                    case '(': s.push(')'); break;
                    case '[': s.push(']'); break;
                    default :
                        if (s.empty() || bracket != s.peek())
                            return false;
                        s.pop();
                }
            return s.empty();

    }


    private static String substitute(String input){
        String ret="";
        String s="";
        for(int i=0; i<input.length(); i++){

            switch (input.substring(i,i+1)) {
                case "(":s=")";
                break;
                case "{":s="}";
                    break;
                case "[":s="]";
                    break;
            }
            ret+=s;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
