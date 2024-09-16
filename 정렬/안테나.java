
import java.io.*;
import java.util.*;


public class Main {
    /**
     * 정렬
     * 안테나
     */
    static int N;
    static int[] home ;


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(home);

        if (N%2 == 0){
            System.out.println(home[N/2-1]);
        }else {
            System.out.println(home[N/2]);
        }

    }
}
