package main.java;

public class Solution {
    public String solution(String rsp) {
        String answer = "";

        //가위 2, 바위 0, 보 5

        char[] chars = rsp.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '2'){
                answer += '0';
            } else if (chars[i] == '0') {
                answer += '5';
            }else {
                answer += '2';
            }
        }

        return answer;
    }
}
