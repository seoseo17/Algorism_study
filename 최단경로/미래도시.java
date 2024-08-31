import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 최단경로
     * 미래도시
     */

    public static final int INF = (int)1e9;
    public static int n,m,x,k;
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i],INF);
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                if (j==i) graph[i][j] = 0;
            }
        }

        for (int i = 0; i <m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int l = 1; l < n+1; l++) {
            for (int i = 1; i <n+1 ; i++) {
                for (int j = 1; j <n+1; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][l]+graph[l][j]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if (distance != INF)
            System.out.println(distance);
        else {
            System.out.println(-1);
        }


    }

}



