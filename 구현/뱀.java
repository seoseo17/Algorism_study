
import java.util.*;


public class Main {
    /**
     * 구현
     * 뱀
     */
    static int[][] board;
    static int n;
    static int[] dx = {0,1,0,-1}; //동,남,서,북
    static int[] dy = {1,0,-1,0};
    static Map<Integer, Character> directions = new HashMap<>();

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int k = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x-1][y-1] = 1; // 사과의 위치
        }

        int l = sc.nextInt();

        for (int i = 0; i < l; i++) {
            int time = sc.nextInt();
            char direction = sc.next().charAt(0);
            directions.put(time, direction);
        }
        simulation();
    }

    static void simulation(){
        int time = 0;
        int dir = 0;
        int cx = 0;
        int cy = 0;
        List<int[]> snake = new LinkedList<>();
        snake.add(new int[]{cx,cy});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (true){
            time++;
            int nx = cx+ dx[dir];
            int ny = cy+ dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) {
                break; // 벽이나 자기 몸에 부딪힘
            }

            if (board[nx][ny] == 1){
                board[nx][ny] = 0;
                visited[nx][ny] = true;
                snake.add(new int[]{nx,ny});
            }else {
                visited[nx][ny] = true;
                snake.add(new int[]{nx,ny});
                int[] tail = snake.remove(0);
                visited[tail[0]][tail[1]] = false;
            }

            if (directions.containsKey(time)){
                if (directions.get(time).equals('D')){
                    dir += 1;
                    if (dir == 4) dir=0;
                }else {
                    dir -= 1;
                    if (dir == -1) dir = 3;
                }
            }
            cx= nx;
            cy = ny;

        }
        System.out.println(time);

    }
    }
