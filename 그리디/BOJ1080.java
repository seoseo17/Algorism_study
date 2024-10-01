
import java.io.*;
import java.util.*;


public class Main {

    static int n,m;
    static int[][] a,b;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        b = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = str.charAt(j)-'0';
            }
        }
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = str.charAt(j)-'0';
            }
        }
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                if (a[i][j] != b[i][j]) {
                    change(i,j);
                    count++;
                }
            }
        }
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(count);
        }else {
            System.out.println(-1);
        }
    }

    static void change(int x, int y){
        int[] dx = {0,1,2,0,1,2,0,1,2};
        int[] dy = {0,0,0,1,1,1,2,2,2};

        int cx = x;
        int cy = y;

        for (int i = 0; i < 9 ; i++) {
            int nx = cx+dx[i];
            int ny = cy+dy[i];

            if (nx >= n || ny >= m) continue;

            if (a[nx][ny] == 1) a[nx][ny] = 0;
            else a[nx][ny] = 1;
        }
    }
}
