
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    int virus;
    int time;
    public Node(int x,int y,int virus,int time){
        this.x =x;
        this.y = y;
        this.time = time;
        this.virus = virus;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getTime(){
        return this.time;
    }
    public int getVirus(){
        return this.virus;
    }
    @Override
    public int compareTo(Node o){
        return this.virus - o.getVirus();
    }

}

public class Main {
    /**
     * DFS/BFS
     * 경쟁적 전염
     */
    static int N,K,S,X,Y;
    static int[][] board;
    static int[] dx = {0,0,-1,1}; //상, 하, 좌, 우
    static int[] dy = {1,-1,0,0}; //상, 하, 좌, 우
    static Queue<Node>virus;
    static List<Node>input = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] =Integer.parseInt(st.nextToken());
                if (board[i][j] != 0) input.add(new Node(i,j,board[i][j],0));
            }
        }
        Collections.sort(input);
        virus = new LinkedList<>(input); // queue는 정렬 보장XX

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); //s초후
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        solve();
        System.out.println(board[X-1][Y-1]);

    }

    static void solve(){
        while (!virus.isEmpty()){
            Node curVirus = virus.poll();

            int cx = curVirus.getX();
            int cy = curVirus.getY();
            int cVirus = curVirus.getVirus();
            int cTime = curVirus.getTime();

            if (cTime == S) return;

            for (int i = 0; i < 4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if (nx<0 || ny<0||nx>=N || ny>=N || board[nx][ny] != 0) continue;
                board[nx][ny] = cVirus;
                virus.add(new Node(nx,ny,cVirus,cTime+1));
            }
        }

    }

    }
