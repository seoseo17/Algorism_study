import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    /**
     * 기타 그래프
     * 위상 정렬
     */

    public static int v, e;
    public static int[] indegree = new int[100001];
    public static ArrayList<Integer>[] graph = new ArrayList[100001];

    public static void topologicalSort(){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        //1. 진입 차수가 0인 노드 queue에 삽입
        for (int i = 1; i < v+1; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);

            //인접해 있는 노드 접근
            for (int next : graph[current]){
                indegree[next]--; //진입차수 -1
                if (indegree[next] ==0) queue.add(next);
            }
        }
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 1; i <v+1 ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i <e ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b); //a->b로 이동가능
            indegree[b]++; //b에 진입차수 증가
        }

        topologicalSort();
    }
    }
