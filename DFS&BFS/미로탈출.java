import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    /**
     * DFS/BFS
     * 미로 탈출
     * */
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        arr =new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j)-'0';
            }
        }
        System.out.println(bfs(0,0));

    }

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i <4 ; i++) {
                int nx =cx+dx[i];
                int ny =cy+dy[i];

                if (nx<0||ny<0 || nx>=n || ny>=m) continue;

                if (arr[nx][ny] == 1 ){
                    queue.offer(new int[]{nx,ny});
                    arr[nx][ny] = arr[cx][cy]+1;
                }
            }
        }
        return arr[n-1][m-1];

    }
}
