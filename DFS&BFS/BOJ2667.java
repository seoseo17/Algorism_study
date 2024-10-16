
import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int M,N,K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        //1 집있음 , 0 집없음
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]==1 && !visited[i][j]){
                    int homeCount = bfs(i,j);
                    list.add(homeCount);
                    count++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for (int i : list) {
            System.out.println(i);
        }
    }

    static int bfs(int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int count =1;
        while (!q.isEmpty()){
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if (nx<0|| ny<0||nx>=N || ny>=N) continue;

                if (!visited[nx][ny] && map[nx][ny] == 1){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
