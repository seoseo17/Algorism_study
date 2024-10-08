
import java.io.*;
import java.util.*;


public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int minValue = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > minValue) {
                for (int j = minValue + 1; j < number + 1; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                minValue = number;
            } else if (stack.peek() != number) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);

    }
}
