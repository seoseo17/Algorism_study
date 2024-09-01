import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    private int nodeA;
    private int nodeB;
    private int distance;

    public Edge(int nodeA,int nodeB, int distance){
        this.nodeA = nodeA;
        this.nodeB= nodeB;
        this.distance =distance;
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
    public int compareTo(Edge other){ // 오름차순 정리
        return this.distance - other.distance;
    }

}


public class Main {
    /**
     * 기타 그래프
     * 크루스칼 알고리즘 (최소 신장 트리)
     */

    public static int v, e;
    public static int[] parent = new int[100001];
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    //특정 원소가 속한 집합
    public static int findParent(int x){
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    //두원소가 속한 집합 합치기
    public static void unionParent(int x,int y){
        x = findParent(x);
        y = findParent(y);
        if (x>y) parent[x] = y;
        else parent[y] = x;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a,b,c));
        }

        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            int cost = edges.get(i).getDistance();

            if (findParent(a) != findParent(b)){
                unionParent(a,b);
                result += cost;
            }
        }
    }
    }







