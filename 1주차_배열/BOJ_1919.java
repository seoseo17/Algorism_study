import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    /**1919 애너그램 만들기 브론즈2*/

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] countStr1 = new int[26];
        int[] countStr2 = new int[26];
        int count = 0;

        for (int i = 0; i < str1.length(); i++) {
            countStr1[str1.charAt(i)-'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            countStr2[str2.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countStr1[i]!=countStr2[i]){
                count += Math.abs(countStr1[i]-countStr2[i]);
            }
        }
        System.out.println(count);

    }

}


