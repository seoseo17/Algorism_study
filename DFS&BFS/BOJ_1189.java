
import java.io.*;
import java.util.*;

/* 1189. 컴백홈 */
public class Main {

    static int R,C,K;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int result = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);
        arr = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            arr[i] = chars;
        }

        // 현수 위치 (r-1,0) 집 위치 (0,c-1)

        visited[R-1][0]  = true;
         // 6만큼 거리인 경우
        solve(R-1,0,1);
        System.out.println(result);
    }
    static void solve(int x,int y, int depth){

        if (x == 0 && y==(C-1)){
            if (depth == K) {
                result++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (nx >= R || ny >= C || nx <0 || ny <0) continue;

            if (arr[nx][ny] != 'T' && !visited[nx][ny]){
                visited[nx][ny] = true;
                solve(nx,ny,depth+1);
                visited[nx][ny] = false;
            }
        }
    }}
