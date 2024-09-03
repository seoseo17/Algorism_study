import java.util.*;

public class Main {
    /**
     * 그리드
     * 문자열 뒤집기
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i)-'0';
        }
        int count0 = 0; //0으로 변경
        int count1 = 0; //1로 변경

        if (arr[0] == 1) count0++;
        else count1++;

        for (int i = 0; i < arr.length-1 ; i++) {
            if (arr[i] != arr[i+1]){
                if (arr[i+1] == 1) count0++;
                else count1++;
            }
        }
        System.out.println(Math.min(count0,count1));
    }
    }
