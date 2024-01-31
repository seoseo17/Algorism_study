package main.java;

public class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        char[] chars = cipher.toCharArray();

        for (int i = 1; i <= chars.length; i++) {
            if((i)%code == 0){
                answer += chars[i-1];
                System.out.println("i = " + i);
            }
        }


        return answer;
    }
}
