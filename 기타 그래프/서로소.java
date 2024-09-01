import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 기타 그래프
     * 서로소 집합
     */
    public static int v, e;
    public static int[] parent = new int[100001];

    //속한 집합 찾기
    public static int findParent(int x){
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    //두 원소가 속한 집합 합치기
    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if (a>b) parent[a] = b;
        else parent[b] =a;
    }

    public static void main(String[] args) throws Exception{
         Scanner sc =new Scanner(System.in);
         v = sc.nextInt();
         e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // Union 연산을 각각 수행
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        //각 원소가 속한 집합 출력
        for (int i = 1; i <v+1 ; i++) {
            System.out.println(findParent(i));
        }
        
        //부모 테이블 출력
        for (int i = 1; i <v+1 ; i++) {
            System.out.println(parent[i]);
        }
    }
}
