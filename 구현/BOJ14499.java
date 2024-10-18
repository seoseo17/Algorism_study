
import java.io.*;
import java.util.*;

public class Main {

    static int N,M,K;
    static int[] commands;
    static int[][] map;
    static int[] dy = {1,-1,0,0}; //동서북남
    static int[] dx = {0,0,-1,1}; //동서북남
    static int[] dice;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로크기
        M = Integer.parseInt(st.nextToken()); //가로 크기
        int x = Integer.parseInt(st.nextToken()); //주사위 놓을 좌표
        int y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 명령의 개수
        dice = new int[6]; //0 위, 1 앞, 2 오른, 3 왼, 4, 뒤, 5 아래
        map = new int[N][M];
        for (int i = 0; i <N ; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        commands = new int[K];
        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            commands[i] = Integer.parseInt(st.nextToken()); //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
        }

        //이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사
        //0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.

        for (int i = 0; i <K ; i++) {
            //바닥 dice[5]; 윗면 dice[0];
            int command = commands[i]-1;

            int nx = x+dx[command];
            int ny = y+dy[command];
            
            //if (nx<0||ny<0||nx>=M|| ny>=N) continue; // 밖으로 나가면 명령 무시
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            int mapNumber = map[nx][ny];
            rollDice(command); // 주사위 이동
            if (mapNumber == 0){
                map[nx][ny] = dice[5];
            }else {
                dice[5] = mapNumber;
                map[nx][ny] = 0;
            }
            x = nx;
            y = ny;
           System.out.println(dice[0]);
        }

    }

    static void rollDice(int direction){
        int temp = 0;
        switch (direction){
            case 0: //동
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5]= dice[2];
                dice[2] = temp;
                break;
            case 1: //서
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5]= dice[3];
                dice[3] = temp;
                break;
            case 2: //북
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5]= dice[1];
                dice[1] = temp;
                break;
            case 3: //남
                temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5]= dice[4];
                dice[4] = temp;
                break;

        }
    }
}

