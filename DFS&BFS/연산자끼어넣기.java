
import java.io.*;
import java.util.*;


public class Main {
    /**
     * DFS/BFS
     * 연산자 끼어넣기
     */
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operator = {0,0,0,0};
    static int numbers[];
    static int N;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            numbers[i] =Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        //음수를 양수로 나눌 때는 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것
        dfs(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int num, int idx){

        if (idx == N){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        for (int i = 0; i < 4; i++) {
            //+,-,X,%
            if (operator[i] >0){
                operator[i] -= 1;
                if (i==0){
                    dfs(num+numbers[idx], idx+1);
                } else if (i == 1) {
                    dfs(num-numbers[idx], idx+1);
                }else if (i == 2) {
                    dfs(num*numbers[idx], idx+1);
                }else if (i == 3) {
                    if (num<0&&numbers[idx]>0){
                        int result = (-num)/numbers[idx];
                        dfs(-result, idx+1);
                    }else {
                        dfs(num/numbers[idx], idx+1);
                    }
                }
                operator[i] += 1;
            }
        }
    }


    }
