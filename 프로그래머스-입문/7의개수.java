import java.util.*;

public class Solution {
    public int solution(int[] array) {
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            String str = String.valueOf(array[i]);
            char[] chars = str.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                if (Integer.parseInt(String.valueOf(chars[j])) == 7) answer ++;
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }
}
