
import java.io.*;
import java.util.*;



public class Main {

    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        String[] str= br.readLine().split(" ");

        for (int i = 0; i <n ; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i <n ; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]){ //내람차순 , arr[i] 현재 원소 기준, arr[j] 이전 원소가 크면
                    dp[i] = Math.max(dp[i],dp[j]+1 );
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(n-max);
    }
}



