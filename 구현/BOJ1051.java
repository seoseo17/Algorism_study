
import java.io.*;
import java.util.*;


public class Main {

    static int N,M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
           String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        int max = Math.min(N,M);
        int result = 1;

        for (int k = 1; k < max; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i+k >=N || j+k >= M){
                        continue;
                    }
                    int range = solve(i,j,arr,k);
                    result = Math.max(result,(range+1));
                }
            }
        }
        System.out.println(result*result);


    }

    static int solve(int x,int y,int[][] arr,int range) {

        // x,y  x+range,y  x,y+range, x+range,y+range -> 같은 값
        int value = arr[x][y];
        if (x+range >=N || y+range >= M) return -1;

        if ((arr[x+range][y] == value) && (arr[x][y+range] == value) && (arr[x+range][y+range] == value) ){
            return range;
        }
        return -1;
    }
}
