
import java.util.*;


public class Main {
    /**
     * 그리드
     * 모험가 길드
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        int result = 0;
        int count = 0;
        Arrays.sort(arr);

        for(int i : arr){
            count += 1;
            if (count >= i){ //if (count == i)로 했으나 문제에서 x명 이상이라했으므로 정확한 것은 >=
                result++;
                count = 0;
            }
        }
        System.out.println(result);
    }
    }







