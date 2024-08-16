import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    /**
     * 정렬
     * 위에서 아래로
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 선택정렬
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] > nums[j] ){
                    int temp=nums[j];
                     nums[j] = nums[i];
                     nums[i] = temp;
                }
            }
        }

        // 삽입정렬
        for (int i = 1; i <n ; i++) {
            int key = nums[i];
            int j = i-1;

            while (j>=0 && nums[j] > key){
                nums[j+1] = nums[j]; // 오른쪽으로 이동
                j--;
            }
            //key가 들어갈 위치
            nums[j+1] = key;
        }


        for (int a : nums){
            System.out.printf("%d ",a);
        }
    }

}



