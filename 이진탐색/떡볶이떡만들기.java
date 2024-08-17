import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 이진탐색
     * 떡볶이떡만들기
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); //요청한 떡의 길이

        int[] foods = new int[n];
        for (int i = 0; i <n; i++) {
            foods[i] = sc.nextInt();
        }
        Arrays.sort(foods);
        System.out.println(binary_search(foods,m,n));

    }

    public static int binary_search(int[] foods,int m,int n){
        int start = 0;
        int end = foods[n-1];
        int sum = 0;
        int result = 0;

        while (start<=end){
            sum = 0;
            int mid = (start+end)/2;

            for (int i : foods){
                if (i>mid) sum += (i-mid);
            }
            if (sum >= m) {
                start = mid+1;
                result = mid;
            }
            else end = mid-1;
        }

        return result;
    }

}



