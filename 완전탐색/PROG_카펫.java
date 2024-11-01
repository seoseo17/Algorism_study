import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //s = b+y = w*h
        //y = (w-2)*(h-2);
        int s = brown+yellow;
        
        for(int i=3; i<=s;i++){
            int h = i;
            int w = s/i;
            if(w<3) continue;
            
            if(w>=h){
                if((w-2)*(h-2) == yellow){
                    answer[0] = w;
                    answer[1] = h;
                    return answer;
                }
            } 
        }
        
        
        return answer;
    }
}
