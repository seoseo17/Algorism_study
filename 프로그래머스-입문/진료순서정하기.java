import java.util.*;

public class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        Integer[] temp = Arrays.stream(emergency).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, Collections.reverseOrder()); //76,24,3

        for (int i =0;i<emergency.length;i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (temp[i] == emergency[j]){
                    answer[j] = i+1;
                }
            }
            
        }

        for (int a : answer){
            System.out.println("a = " + a);
        }
        return answer;
    }
}
