package main.java;

import java.util.stream.*;

public class Solution {
    public int[][] solution(int[] num_list, int n) {
        int a = num_list.length/n;

        int[][] answer = new int[a][n];

        int index = 0;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = num_list[index++];
            }
        }

//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.printf("i: %d, j: %d, %d\n", i,j, answer[i][j]);
//            }
//        }

        return answer;
    }
}
