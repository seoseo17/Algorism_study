import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 정렬
     * 두 배열의 원소 교체
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] arrA = new Integer[n];
        Integer[] arrB = new Integer[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }

        //1. arrA 오름차순, arrB 내림차순
        Arrays.sort(arrA);
        Arrays.sort(arrB,Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (arrA[i] < arrB[i]){
                int temp = arrA[i];
                arrA[i] = arrB[i];
                arrB[i] = temp;
            }else {
                break; // 반복문 돌 이유가 없음
            }
        }

        int result = 0;
        for (int i : arrA){
            result += i;
        }
        System.out.println(result);

    }

}



