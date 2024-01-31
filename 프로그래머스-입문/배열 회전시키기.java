package main.java;

public class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        if (direction.equals("right")) {

            //1.마지막 인덱스가 0번째가 된다
            answer[0] = numbers[numbers.length-1];
            //2. numbers[0]-> 1, 1->2 ,..., n-1- > n
            for (int i = 0; i < numbers.length-1; i++) {
                answer[i+1] = numbers[i];
            }
        }else {
            //1. 0번째 인덱스 가 마지막 인덱스
            answer[numbers.length-1] = numbers[0];

            //2. numbers[1]->0 , 2->1, ..., n->n-1
            for (int i = 0; i < numbers.length-1; i++) {
                answer[i] = numbers[i+1];
            }
        }


        for (int n: answer){
            System.out.print(n);
        }


        return answer;
    }
}
