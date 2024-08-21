import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 다이나믹 프로그래밍
     * 바닥공사
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //a1 = ai-1 + ai-2*2
        int[] d= new int[1001];
        d[1] = 1;
        d[2] = 3;

        for (int i = 3; i <n+1 ; i++) {
            d[i] = (d[i-1]+ d[i-2]*2)%796796;
        }

        System.out.println(d[n]);
    }

}



