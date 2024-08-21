import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 다이나믹 프로그래밍
     * 효율적인화폐구성
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] money = new int[n];
        for (int i = 0; i <n ; i++) {
            money[i] = sc.nextInt();
        }

        int[] d = new int[m+1];
        Arrays.fill(d,10001);

        d[0] = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = money[i]; j <m+1 ; j++) {
              //j-money : 만들고자한 금액 - 현재화페금액
              // 예를 들어 5-2 = 3 , 즉 2원이 있으면 3+2해서 금액을 만들 수 있다
                d[j] = Math.min(d[j],d[j-money[i]]+1); 

            }
        }
        if (d[m] == 10001) {
            System.out.println(-1);
        }
        else {
            System.out.println(d[m]);
        }

    }

}



