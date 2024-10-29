import java.util.*;
class Solution {
    private boolean[] visited;
    private int size;
    private Set<Integer> numberSet;
    
    public int solution(String numbers) {
        int answer = 0;
        
        size = numbers.length();
        int[] arr = new int[size];
        
        for(int i=0;i<size;i++){
            arr[i] = numbers.charAt(i)-'0';
        }
        visited = new boolean[size];
        numberSet = new HashSet<>();
        combine(arr,0);

        for(int i: numberSet){
            if(isPrime(i)){
                answer++;
                System.out.println(i);
            }
        }
        
        return answer;
    }
    
    private void combine(int[] arr, int current){
        if(current!=0){
            numberSet.add(current);
        }
        for(int i=0;i<size;i++){
            if(!visited[i]){
                visited[i] = true;
                combine(arr,current*10+arr[i]);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num){
        
        if(num<2) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i == 0) return false;
        }
        
        return true;
    }
}
