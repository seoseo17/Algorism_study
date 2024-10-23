import java.util.*;
import java.io.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                 bfs(i,computers,n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(int x,int[][] computers,int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        int count =0;
        
        while(!q.isEmpty()){
            int cx = q.poll();
            
            for(int i=0;i<n;i++){
                
                if(!visited[i] && computers[cx][i] == 1){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
