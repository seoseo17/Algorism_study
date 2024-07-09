import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);

        int x = scanner.nextInt();

        int lt = 0;
        int rt = n-1;

        int count = 0;

        while (lt<rt){
            int sum = nums[lt]+nums[rt];
            if(sum == x) count++;
            if (sum > x){
                rt--;
            }else{
                lt++;
            }
        }

        System.out.println(count);


    }
}
