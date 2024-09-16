
import java.io.*;
import java.util.*;


public class Main {
    /**
     * DFS/BFS
     * 감시 피하기
     */
    static int N,X,S,T;
    static char[][] board;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static List<int[]> teachers = new ArrayList<>();
    static List<int[]> students = new ArrayList<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <N ; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if (board[i][j] == 'S'){
                    students.add(new int[]{i,j});
                } else if (board[i][j] == 'T') {
                    teachers.add(new int[]{i,j});

                }
            }
        }
        solve(0);
        System.out.println("NO");

    }

    static void solve(int count){

        if (count == 3){
            if (bfs()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'X'){
                    board[i][j] = 'O';
                    solve(count+1);
                    board[i][j] = 'X';
                }
            }
        }
    }
    static boolean bfs(){
        Queue<int[]> queue = new LinkedList<>();
        char[][] copyBoard = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyBoard[i][j] = board[i][j];
                if (board[i][j] == 'T') queue.offer(new int[]{i,j});
            }
        }

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                while(nx>=0&&ny>=0&&nx<N&& ny<N){
                    if (copyBoard[nx][ny] == 'S') return false;
                    if (copyBoard[nx][ny] == 'O') break; //장애물 만나면 더이상 확인X
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        return true;
    }
}
