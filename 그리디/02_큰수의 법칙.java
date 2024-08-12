import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 그리디
     * 큰 수의 법칙
     * */

    public static void main(String[] args) throws Exception {

        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n, m, k;
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums); // 오름차순
        int first = nums[n - 1];
        int second = nums[n - 2];
        int result = 0;

        while (m >0) {

            for (int i = 0; i < k; i++) {
                result += first;
                m -= 1;
            }
            if (m == 0) break;
            result += second;
            m -= 1;
        }
        System.out.println(result);

    }
}


