
import java.io.*;
import java.util.*;


public class Main {

    /**
     * 기타그래프
     * 플로이드
     */
    static int N,M;
    static int[][] arr;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = INF;
                if (i==j) arr[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[x-1][y-1] = Math.min(cost, arr[x-1][y-1]);
        }


        for (int k = 0; k < N; k++) { //노드 1개부터 n개를 거쳐가는 경우 모두 고려
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // k번째 노드를 거치는 경우와, 기존 루트를 비교해서 더 작은 값으로
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == INF){
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
