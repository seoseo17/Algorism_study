import java.util.*;
import java.io.*;

class Music implements Comparable<Music>{
    private String genre;
    private int count;
    private int index;
    
    public Music(String genre, int count, int index){
        this.genre = genre;
        this.count = count;
        this.index = index;
    }
    
    public int getIndex(){
        return index;
    }
    
    @Override
    public int compareTo(Music o){
        
        if(o.count == this.count){ //index 오름차순으로
            return this.count-o.count;
        }else{
            return o.count - this.count;
        }
    }
    
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int gSize = genres.length;
        int pSize = plays.length;
        
        //각 장르마다 재생횟수로 정렬 
        // 각 장르마다 2개씩 뽑아, 가장 많은 재생횟수 장르 가 먼저

        Map<String,List<Music>> genreMap = new HashMap<>();
        Map<String,Integer> totalCount = new HashMap<>();
        
        for(int i=0;i<gSize;i++){
            genreMap.put(genres[i],new ArrayList<>());
            totalCount.put(genres[i],0);
            
        }
        
        for(int i=0;i<gSize;i++){
           List<Music> list = genreMap.get(genres[i]);
            list.add(new Music(genres[i],plays[i],i));
            
            totalCount.put(genres[i], totalCount.get(genres[i])+plays[i]);   
        }
        
        
        // key-> 배열로 만들어 총 횟수 순으로 정렬, 내림차순
        List<String> sortedCount = new ArrayList<>(totalCount.keySet());
        sortedCount.sort((a,b)->totalCount.get(b).compareTo(totalCount.get(a)));
        
        // 장르면 상위 2개
        List<Integer> result = new ArrayList<>();
        for(String s: sortedCount){
            List<Music> list = genreMap.get(s);
            Collections.sort(list);
            
            // 2보다 작을 수 있음
            if(list.size()<2){
                Music m = list.get(0);
                result.add(m.getIndex());
                continue;
            }
            
            for(int i=0;i<2;i++){
                Music m = list.get(i);
                result.add(m.getIndex());
            }
        }
        
        //list->배열로
        answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}
