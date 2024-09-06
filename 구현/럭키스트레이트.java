
import java.util.*;
import java.util.stream.Stream;


public class Main {
    /**
     * 구현
     * 럭티 스트레이트
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();

        int half = s.length()/2;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i<half) sum1 += chars[i]-'0';
            else  sum2 += chars[i]-'0';
        }

        if (sum1 == sum2) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
    }
