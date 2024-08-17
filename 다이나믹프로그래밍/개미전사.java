import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 다이나믹 프로그래밍
     * 개미전사
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] d = new int[100];

        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        d[0] = arr[0];
        d[1] = Math.max(d[0],d[1]);
        for (int i = 2; i <n ; i++) {
            d[i] = Math.max(arr[i-1], arr[i-2]+arr[i]);
            //arr[i-1] : 현재 창고 털지 않고, 이전 창고 유지
            //arr[i-2]+arr[i] :현재 창고를 털고, 전전 창고 더하기
        }
        System.out.println(d[n-1]);
    }
}



