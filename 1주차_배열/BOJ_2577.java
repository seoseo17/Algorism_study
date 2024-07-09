import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int count = 0;
        int[] nums = new int[10];

        while(num>0){
            int d = num%10;
            if (d == 9) d=6;
            num = num/10;
            nums[d]++;
        }
/** 반례)666 -> 원래 코드 1 출력 되어서 if문으로 홀수일 때 처리*/
        if (nums[6] >1){
            if (nums[6]%2 == 0){
                nums[6] = nums[6]/2;
            }else {
                nums[6] = nums[6]/2+1;
            }
        }

        while (true){
            int sum = Arrays.stream(nums).sum();
            if (sum == 0) break;

            for (int i = 0; i < 10; i++) {
                if(nums[i] == 0) continue;
                nums[i]--;
            }
            count++;

        }
        System.out.println(count);

    }
}
