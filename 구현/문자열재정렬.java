
import java.util.*;
import java.util.stream.Stream;


public class Main {
    /**
     * 구현
     * 문자열 재정렬
     */

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int sum = 0;

        ArrayList<Character> charList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            int n = chars[i]-'0';
            if (n>=0 && n<=9) sum += n;
            else charList.add(chars[i]);
        }

        Collections.sort(charList);

        for (char c :charList){
            System.out.print(c);
        }
        if (sum!= 0) System.out.print(sum);
    }
    }
