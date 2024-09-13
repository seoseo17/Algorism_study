
import java.io.*;
import java.util.*;


public class Main {
    /**
     * DFS/BFS
     * 특정거리의 도시 찾기
     */
    static int M,N,K,X;
    static ArrayList<Integer>[] map;
    static int[] distance;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //최단거리
        X = Integer.parseInt(st.nextToken()); //출발도시
        map = new ArrayList[N+1];
        distance = new int[N+1];
        Arrays.fill(distance,-1);

        for (int i = 1; i <N+1 ; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 1; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
        }
        distance[X] = 0; //출발도시 초기화
        bfs();

        for (int i = 1; i <N+1 ; i++) {
            if(distance[i]==K){
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        }else {
            answer.stream().sorted();
            for (int i : answer){
                System.out.println(i);
            }
        }
    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);

        while (!queue.isEmpty()){
            int current = queue.poll();

            for (int next : map[current]){
                if (distance[next]== -1){
                    distance[next] = distance[current]+1; //X의 도시에서 각 도시에 최단거리
                    queue.offer(next);
                }
            }
        }

    }
    }
