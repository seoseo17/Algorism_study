
import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] arr;
    static boolean[] visited;
    static int blue, white;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);

        //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

        arr = new int[M];
        backTracking(1,0);

    }

    static void backTracking(int start, int depth){

        if (depth == M){ //M개 다 골랐으면 return
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <=N ; i++) {
            arr[depth] = i;
            backTracking(i+1,depth+1);
        }
    }
}
