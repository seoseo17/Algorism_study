
import java.io.*;
import java.util.*;


public class Main {

    static int N,M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.length();
        Stack<Character> stack =new Stack<>();

        int result = 0;
        int value = 1;
        for (int i = 0; i < size; i++) {
            char c = str.charAt(i);
            if (c == '('){
                stack.push(c);
                value *= 2;
            } else if (c == '[') {
                stack.push(c);
                value *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(' ) {
                    result = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(') result += value;
                stack.pop();
                value /= 2;

            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (str.charAt(i - 1) == '[') result += value;
                stack.pop();
                value /= 3;
            }
        }
        if (!stack.isEmpty()){
            result = 0;
        }
        System.out.println(result);
    }
}
