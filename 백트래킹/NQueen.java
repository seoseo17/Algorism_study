
import java.io.*;
import java.util.*;

public class Main {

    /**
     * 브루트포스
     * N-queen
     */
    static int N,result;
    static int[][] board;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        // 일직선상(가로 및 세로)과 대각선 방향에는 아무것도 놓여있으면 안 됨
        board = new int[N][N];

        result = 0;

        solve(0) ;// 첫번째 행부터
        System.out.println(result);
    }

    static void solve(int row){

            if (row == N){ //행을 다 채우면
                result++;
                return;
            }

            for (int col = 0; col < N; col++) {
                if (isCheck(row, col)){
                     // 체스를 해당 열에 놓을 수 있는지 확인
                    board[row][col] = 1;
                    solve(row+1);
                    board[row][col] = 0;
                }
            }
    }


    static boolean isCheck(int row, int col){

        //1. 같은 열에 체스가 있는지
        for (int i = 0; i < row; i++) {
            if (board[i][col] ==1) return false;
        }

        //2. 대각선에 체스가 있는지
        // 오른쪽
        for (int i = 1; i <= row && col+i <N; i++) {
            if (board[row-i][col+i] ==1 )return false;
        }

        for (int i = 1; i <= row && col-i>=0 ; i++) {
            if (board[row-i][col-i] ==1) return false;
        }

        return true;
    }

}
