import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 다이나믹 프로그래밍
     * 1로 만들기
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int[] nums = new int[30001]; // nums[i] -> i를 1로 만드는데 최소한의 수

        for (int i = 2; i <= x ; i++) {
            nums[i] = nums[i-1]+1;
            if (i%5 == 0){
                nums[i] = Math.min(nums[i],nums[i/5]+1);
            }
            if (i%3 == 0){
                nums[i] = Math.min(nums[i],nums[i/3]+1);
            }
            if (i%2 == 0) {
                nums[i] = Math.min(nums[i], nums[i/2] + 1);
            }

        }
        System.out.println(nums[x]);
    }
}

