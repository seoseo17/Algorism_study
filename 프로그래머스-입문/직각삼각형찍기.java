package main.java;

public class Solution {
    public void solution(int numbers) {
        for (int i = 1; i <= numbers; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
