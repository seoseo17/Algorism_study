import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i:arr){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            if(i == stack.peek()) continue;
            else{
                stack.push(i);
            }
        }
        answer = new int[stack.size()];
        for(int i=0;i<stack.size();i++){
            answer[i] = stack.get(i);
        }
        
        return answer;
    }
}
