
import java.util.*;


public class Main {
    /**
     * 그리드
     * 곱하기 혹은 더하기
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i)-'0';
        }
        //Arrays.sort(arr); -> sort 필요 없음
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int a = arr[i];

            if (a<=1 || result <=1) result += a;
            else result *= a;
        }
        System.out.println(result);
    }
    }
