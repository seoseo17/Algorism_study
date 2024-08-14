import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    /**
     * 구현
     * 게임 개발
     * */

    static int[] dx = {0,1,0,-1}; //북동남서
    static int[] dy = {1,0,-1,0};
    static int d;

    static void turn_left(){
        d = d-1;
        if(d == -1) d = 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");

        int row = Integer.parseInt(str[0]);
        int col = Integer.parseInt(str[1]);

        int[][] map = new int[row][col];
        boolean[][] visited = new boolean[row][col];

        String[] location = bf.readLine().split(" ");
        int x = Integer.parseInt(location[0]);
        int y = Integer.parseInt(location[1]);
        d = Integer.parseInt(location[2]);
        visited[x][y] = true; // 방문처리

        for (int i = 0; i < row; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < col; j++) {
              map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 1;
        int turnTime = 0;
        while (true){
            // 1. 방향 회전 후 갈 곳 확인
            turn_left();
            turnTime++;
            int nx = x+dx[d];
            int ny = y+dy[d];

            if (map[nx][ny] != 1 && !visited[nx][ny]){
                visited[nx][ny] = true;
                x = nx;
                y = ny; // 이동
                count++;
                turnTime = 0;
                continue;
            }else {
                turnTime++;
            }

            if (turnTime == 4){
                nx = x-dx[d];
                ny =y-dy[d]; // 1단계 전으로 돌아가기
                turnTime = 0;
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }else {
                    break;
                }
            }
        }
        System.out.println(count);
    }

}


