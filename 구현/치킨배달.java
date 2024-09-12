
import java.io.*;
import java.util.*;


public class Main {
    /**
     * 구현
     * 치킨 배달
     */
    static int N,M,result;
    static int[][] map;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> selected = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        //0은 빈 칸, 1은 집, 2는 치킨집
        //도시의 치킨 거리가 가장 작게
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //최대 치킨 집 수
        result = Integer.MAX_VALUE;

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) house.add(new int[]{i,j});
                else if (map[i][j] == 2) chicken.add(new int[]{i,j});
            }
        }

        solve(0,0);
        System.out.println(result);

    }

    static void solve(int count, int start){
        if (count == M){
            int total = 0;
            for (int[] h : house){
                int hx = h[0];
                int hy = h[1];
                int min = Integer.MAX_VALUE;
                for (int[] chick: selected){
                    int chx = chick[0];
                    int chy = chick[1];

                    int chickenDistance = Math.abs(hx-chx) + Math.abs(hy-chy);
                    min = Math.min(min,chickenDistance);
                }
                total += min;
            }
            result = Math.min(total,result);
            return;
        }

        //백트래킹
        for (int i = start; i <chicken.size() ; i++) {
                selected.add(chicken.get(i));
                solve(count+1,i+1);
                selected.remove(selected.size()-1);
        }

    }

    }
