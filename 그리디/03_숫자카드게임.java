import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 그리디
     * 숫자 카드 게임
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] arr = new int[n][m];
        int[] minArr = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            int min = 10001;
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (min > arr[i][j]) min = arr[i][j];
            }
           result = Math.max(result,min);
        }
        System.out.println(result);


        /**
         * 배열에 넣고 정렬해서 가장 큰 수 찾기
         * */

//        for (int i = 0; i < n; i++) {
//            int min = 10001;
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = sc.nextInt();
//                if (min > arr[i][j]) min = arr[i][j];
//            }
//            minArr[i] = min;
//        }
//        Arrays.sort(minArr);
//        System.out.println(minArr[n-1]);
    }
}


