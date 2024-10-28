import java.util.*;

class Solution {
    
    private int size;
    private boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        
        //2. 짧은 변환 과정 -> bfs, 
        //3.  글 차이가 1개인 값
        size = words.length;
        visited = new boolean[size];
        
        return bfs(begin,target,words);
    }
    
    private int bfs(String begin, String target, String[] words){
        
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        int count = 0;
        
        while(!q.isEmpty()){
            
            int qSize = q.size();
            count++;
            
            for(int j=0;j<qSize;j++){
                String current = q.poll();
            
                if(current.equals(target)){
                    return count-1;
                }
            
                for(int i=0;i<size;i++){
                    if(visited[i]) continue;

                    String next = words[i];

                    if(check(current, next)){
                    //System.out.println("current:"+current+", next: "+next);
                    //System.out.println("i:"+i);
                        q.offer(next);
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
    
    private boolean check(String current, String next){
        int charCount = 0;
        for(int i=0;i<next.length();i++){
            if(current.charAt(i)!=next.charAt(i)){
                charCount++;
            }
            if(charCount >1) return false;
        }
        return true;
    }
}
