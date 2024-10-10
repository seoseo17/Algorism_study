
import java.io.*;
import java.util.*;


public class Main {

    static int N,M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            Stack<Character> stack =new Stack<>();
            for (int j = 0; j < chars.length; j++) {
                if (stack.isEmpty()){
                    stack.add(chars[j]);
                }else {
                    // 1. stack 상단과 값을 비교
                    if (stack.peek().equals(chars[j])){
                        stack.pop();
                    }else {
                        //같이 다르다면
                        stack.add(chars[j]);
                    }
                }
            }
            
            if (stack.isEmpty()) count++;
        }
        System.out.println(count);

    }
}
