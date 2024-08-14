import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * DFS/BFS
     * 음료수 얼려 먹기
     * */
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] arr;
    static boolean[][] visited;

    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        arr = new int[n][m];
        visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i <n ; i++) {
            String str2 = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str2.charAt(j)-'0';
            }
        }

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !visited[i][j]){
                    bfs(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    public static void bfs(int x,int y){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx <0 || ny <0|| nx>=n|| ny>=m) continue;

            if (arr[nx][ny] == 0 && !visited[nx][ny]) bfs(nx,ny);

        }
    }

}


