
import java.util.*;

class Edge implements Comparable<Edge>{
    private int nodeA;
    private int nodeB;
    private int distance;

    public Edge(int nodeA,int nodeB,int distance){
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.distance = distance;
    }
    public int getNodeA(){
        return nodeA;
    }
    public int getNodeB(){
        return nodeB;
    }
    public int getDistance(){
        return distance;
    }
    @Override
    public int compareTo(Edge other){
        return this.distance - other.getDistance();
    }
}


public class Main {
    /**
     * 기타 그래프
     * 도시 분할 그래프 -> 최소 신장트리 : 크루이칼알고리즘?
     */

    public static int n, m;
    public static int[] parent = new int[100001];
    public static ArrayList<Edge> edges= new ArrayList<>();

    public static int findParent(int x){
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a,int b){
        a = findParent(a);
        b = findParent(b);

        if (a>b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int result  = 0; // 간선 최소 비용
        int last = 0;// 간선 중 가장 큰 비용

        for (int i = 1; i <=n ; i++) {
            parent[i] = i;
        }
        //간선 정보 받기
        for (int i = 0; i <m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(a,b,cost));
        }
        Collections.sort(edges);

        for (Edge e : edges){
            int a = e.getNodeA();
            int b= e.getNodeB();
            int cost = e.getDistance();

            if (findParent(a)!= findParent(b)){ //같지 않을 경우 -> 사이클 발생x
                unionParent(a,b);
                result += cost;
                last = cost; // cost 오름차순이므로 가장 마지막 값이 가장 큰 간선비용
            }
        }
        System.out.println(result-last);

    }
    }
