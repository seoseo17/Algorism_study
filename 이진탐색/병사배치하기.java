
import java.io.*;
import java.util.*;



public class Main {

    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        String[] str= br.readLine().split(" ");

        for (int i = 0; i <n ; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int length = 0; //탐색 종료 인덱스
        for (int i = 0; i < n; i++) {
            int current = arr[i];

            int pos = binarySearch(0,length,current);

            dp[pos] = current;

            if (pos == length) length++; // 가장 큰 부분 수열의 크기
        }
        System.out.println(n-length);
    }

    public static int binarySearch(int left, int right, int key) {
        while (left < right) {
            int mid = (left + right) / 2;
            // 내림차순이므로, dp[mid]가 key보다 크면 오른쪽으로 이동
            if (dp[mid] > key) {
                left = mid + 1; // key보다 작은 값 탐색 (mid 위치에 key 들어올 수 없음 -> +1)
            } else {
                right = mid; // key보다 크거나 같은 값 탐색(mid 위치에 key 들어 올 수 있음)
            }
        }
        return left; // key가 들어가야 할 위치
    }
}



