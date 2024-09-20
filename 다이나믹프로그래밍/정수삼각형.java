
import java.io.*;
import java.util.*;


public class Main {

    /**
     * 다이나믹프로그래밍
     * 정수 삼각형
     */
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i-1][0]+arr[i][0];
            for (int j = 1; j < i+1; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
        }
        int max = dp[N-1][0];
        for (int i = 1; i < N; i++) {
            if (max < dp[N-1][i]) max = dp[N-1][i];
        }
        System.out.println(max);
    }
}
