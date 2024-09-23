
import java.io.*;
import java.util.*;

public class Main {

    /**
     * 다이나믹프로그래밍
     * 퇴사
     */
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] Ti = new int[N];
        int[] Pi = new int[N];
        for (int i = 0; i <N ; i++) {
            String[] chars = br.readLine().split(" ");
            Ti[i] = Integer.parseInt(chars[0]);
            Pi[i] = Integer.parseInt(chars[1]);
        }
        int[] dp = new int[N+1];

        for (int i = 0; i <N ; i++) {
            if (i+Ti[i]<N+1){
                dp[i+Ti[i]] = Math.max(dp[i+Ti[i]], dp[i]+Pi[i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[N]);
    }
}
