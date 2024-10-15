
import java.io.*;
import java.util.*;

class Tomato{
    private int day;

    private int x;
    private int y;
    private int z;
    public Tomato(int x,int y, int z, int day){
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getZ() {
        return z;
    }
    public int getDay() {
        return day;
    }
}

public class Main {

    static int[][][] box;
    static boolean[][][] visited;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0,};
    static int[] dz = {0,0,0,0,1,-1};
    static int M,N,H;
    static Queue<Tomato> queue;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        queue = new LinkedList<>();

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    box[k][i][j] = num;
                    if (num == 1) queue.offer(new Tomato(j,i,k,0));
                }
            }
        }
        int day = bfs();

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[k][i][j] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(day);
    }
    static int bfs(){
        int minDay = -1;

        while (!queue.isEmpty()){
            Tomato tomato = queue.poll();
            int cx = tomato.getX();
            int cy = tomato.getY();
            int cz = tomato.getZ();
            int day = tomato.getDay();
            minDay = Math.max(day,minDay);

            visited[cz][cy][cx] = true;

            for (int i = 0; i < 6; i++) {
                int nx =cx+dx[i];
                int ny =cy+dy[i];
                int nz =cz+dz[i];

                if (nx<0||ny<0||nz<0 ||nx>=M||ny>=N||nz>=H) continue;

                if (!visited[nz][ny][nx] && box[nz][ny][nx] == 0){
                    visited[nz][ny][nx] = true;
                    box[nz][ny][nx] = 1;
                    queue.offer(new Tomato(nx,ny,nz,day+1));
                }
            }
        }
        return minDay;
    }

}
