import java.util.*;

public class Main {
    /**
     * 이진탐색
     * 부품 찾기
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); //오름차순 정렬

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        for (int i : targets){
            boolean result = binary_search(0,n-1,i,arr);
            if (result) System.out.printf("yes ");
            else System.out.printf("no ");
        }

    }

    public static boolean binary_search(int start, int end, int target, int[] array){

        while (start<= end){
            int mid = (start+end)/2;

            if (array[mid] == target) return true;

            if (target>mid){
                start = mid+1;
            }else {
                end = mid+1;
            }
        }
        return false;
    }

}



