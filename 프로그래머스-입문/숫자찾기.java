package main.java;

import java.util.stream.*;

public class Solution {
    public int solution(int num, int k) {
        int answer = -1;

        int[] arr = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length; i++) {
            if (k == arr[i]){
                answer = i+1;
                break;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
