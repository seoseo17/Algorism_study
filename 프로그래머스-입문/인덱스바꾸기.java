package main.java;

public class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";

        char[] chars = my_string.toCharArray();
        char c1 = chars[num1];
        char c2 = chars[num2];

        chars[num2] =c1;
        chars[num1] =c2;

        answer = String.valueOf(chars);
        return answer;
    }
}
