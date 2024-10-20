import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int n = citations.length;
        
        Arrays.sort(citations); // 오름차순 0,1,3,5,6;
        int maxH = 0;
        for(int i=0;i<n;i++){
            int h = citations[i]; // 현재 인용수
            //n-i -> 현재 인용수 이상의 논문 수  
            int count = n-i;
            if(count<=h){
                maxH = h;
                break;
            }
        
        }
        
        
        return maxH;
    }
}
