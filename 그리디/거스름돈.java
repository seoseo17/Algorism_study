import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /**
     * 그리디
     * 최소한의 거스름돈 문제
     * */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int count = 0;

        int[] arr = {500,100,50,10};

        for (int i = 0; i < 4; i++) {
            count += money/arr[i];
            money %= arr[i];
        }
        System.out.println(count);
    }

}


