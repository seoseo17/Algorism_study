
import java.util.*;

public class Main {
    /**
     * 기타 그래프
     * 커리큘럼 -> 위상정렬 (큐와 진입차수필요)
     */

    public static int n;
    public static int[] indegree = new int[501];
    public static ArrayList<Integer>[] graph = new ArrayList[501];
    public static int[] time = new int[501];

    public static void topoloySort(){
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[501];
        for (int i = 1; i <=n ; i++) {
            result[i] = time[i];
        }

        for (int i = 1; i <=n ; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            int current = queue.poll();

            //해당 노드와 연결된 노드 꺼내기
            for (int next : graph[current]){
                //특정 작업을 완료하는 데 걸리는 시간을 계산->  여러 경로 중에서 가장 긴 경로를 고려
                result[next] = Math.max(result[next],result[current]+time[next]);
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

        for (int i = 1; i <n+1 ; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 1; i <n+1 ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n+1; i++) {
            int x = sc.nextInt();
            time[i] = x;
            while (true){
                int y = sc.nextInt();
                if (y == -1) break;
                indegree[i]++;
                graph[y].add(i); // i 수행전 y가 선수필요!
            }
        }
        topoloySort();
    }
    }
