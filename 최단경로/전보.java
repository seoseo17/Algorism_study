import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int cost;

    Node(int index,int cost){
        this.index = index;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public int getCost(){
        return cost;
    }


    @Override
    public int compareTo(Node o) {
       if (this.cost < o.cost) return -1;
       return 1;
    }
}

public class Main {
    /**
     * 최단경로
     * 전보
     */
    static int n,m,c;
    static ArrayList<Node>[] graph;
    static int[] d; //최단 거리 테이블
    static final int INF = (int)1e9;

    public static void main(String[] args) throws Exception{
        //도시의 개수 n, 통로의 개수 m, 메세지 보내고자 한 도시c
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        d = new int[n+1];
        Arrays.fill(d,INF);

        graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i <m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y,z)); // x -> y 가는 비용 :z
        }

        dijstara(c);

        int count = 0;
        int maxDistance =0;

        for (int i = 1; i <n+1 ; i++) {
            if (d[i] != INF){
                count++;
                maxDistance = Math.max(maxDistance,d[i]);
            }
        }

        System.out.println(count-1+" "+maxDistance); //count -1 : 자기자신X
    }

    static void dijstara(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(); //cost가 적은 순으로 처리
        pq.offer(new Node(start,0 )); // 시작노드에서 최단거리O
        d[start] = 0;

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int cost = node.getCost();
            int now = node.getIndex(); //현재 위치

            if (d[now] < cost) continue; // 이미 처리되었다면 넘어가

            for (Node next : graph[now]){

                // 인접 노드를 거쳐가는 것이 더 짧은 경로라면 최단 거리 갱신
                if (d[next.getIndex()] > d[now]+ next.getCost()){
                    d[next.getIndex()] = d[now] + next.getCost();
                    pq.offer(new Node(next.index, d[next.index]));
                }
            }

        }

    }


}



