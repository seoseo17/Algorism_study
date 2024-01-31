package main.java;

import java.util.stream.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        // 약수의 개수가 세 개 이상인 수를 합성수
        //468910
        if (n<4) {
            return answer;
        }else {
            answer = 1;
            for (int i = 5; i <= n; i++) {
                int count = 0;
                for (int j = 1; j <=i ; j++) {
                    if (i%j ==0) count ++;
                }

                if(count>=3) answer++;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
